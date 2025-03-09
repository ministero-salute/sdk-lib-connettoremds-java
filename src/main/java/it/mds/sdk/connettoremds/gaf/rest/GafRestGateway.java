package it.mds.sdk.connettoremds.gaf.rest;

import it.mds.sdk.connettoremds.enums.EsitoDownloadEnum;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.gaf.rest.request.InformazioniFlusso;
import it.mds.sdk.connettoremds.gaf.rest.response.FileUploadAPIResponseDTO;
import it.mds.sdk.connettoremds.gaf.rest.response.MonitoringResponseDTO;
import it.mds.sdk.connettoremds.gaf.webservices.bean.ResponseDwnldScartiAnomaliUpload;
import it.mds.sdk.connettoremds.gaf.webservices.bean.UploadRichiestaScartiAnomaliIn;
import it.mds.sdk.connettoremds.modelli.EsitoDownloadMds;
import it.mds.sdk.connettoremds.modelli.ResponseDwnldScartiAnomaliUploadWithFile;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Component
@ConditionalOnProperty(name = "connettoreMds.type", havingValue = "REST", matchIfMissing = false)
public class GafRestGateway {

    private static final String FILE_UPLOAD_ENDPOINT = "/{category}/{fileType}/{rifYear}/{period}/file";

    private static final String DETAILS_ESITO_UPLOAD_ENDPOINT = "/monitor/details/{category}/{uploadId}";
    private static final String ESITO_UPLOAD_ENDPOINT = "/monitor/search";

    private static final String DOWNLOAD_FUS_ENDPOINT = "/upload/xmlErrors/{uploadId}";

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired(required = false)
    Authorizer<HttpHeaders> authorizer;

    @Value("${url.webservice.gaf}")
    String gafBaseUrl;

    @Value("${connettoreMds.rest.mdsClientId}")
    String mdsClientId;


    <T> ResponseEntity<T> send(String url, HttpMethod method, @Nullable HttpEntity<?> requestEntity,
                               Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        requestEntity.getHeaders().add("Correlation-Id", UUID.randomUUID().toString());
        requestEntity.getHeaders().add("mds-client-id", mdsClientId);
        Optional.ofNullable(authorizer).ifPresent(a -> a.authorize(requestEntity.getHeaders()));

        return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
    }


    public FileUploadAPIResponseDTO callInvioFlussi(InformazioniFlusso informazioniFlusso, Path fileToSend) throws ConnettoreMdsException {

        String uploadFileUrl = gafBaseUrl + FILE_UPLOAD_ENDPOINT;
        try {
            MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
            form.add("file", new FileSystemResource(fileToSend));

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, httpHeaders);

            ResponseEntity<FileUploadAPIResponseDTO> response = this.send(uploadFileUrl, HttpMethod.POST, requestEntity, FileUploadAPIResponseDTO.class, createPathParamsInvioFlussi(informazioniFlusso));


            return manageResponse(response);
        } catch (Exception e) {
            log.error("{}.callInvioFlussi - endpoint[{}] - informazioniFlusso[{}] - fileToSend[{}]",
                    this.getClass().getName(), uploadFileUrl, informazioniFlusso.toString(), fileToSend, e);
            throw new ConnettoreMdsException("Errore nella chiamata al ministero: " + e.getMessage(), e);
        }

    }

    private Map<String, String> createPathParamsInvioFlussi(InformazioniFlusso informazioniFlusso) {
        Map<String, String> pathParams = new HashMap<>();

        pathParams.put("category", informazioniFlusso.getCategoriaFlusso());
        pathParams.put("fileType", informazioniFlusso.getNomeFlusso());
        pathParams.put("rifYear", informazioniFlusso.getAnnoRiferimento());
        pathParams.put("period", informazioniFlusso.getPeriodoRiferimento());

        return pathParams;
    }



    public MonitoringResponseDTO callEsitoUpload(String uploadId, String category) {
        String endpoint = this.gafBaseUrl + ESITO_UPLOAD_ENDPOINT;
        log.debug("{}.callEsitoUpload - endpoint[{}] - uploadMonitoraggioIn[{}] - BEGIN",
                this.getClass().getName(), endpoint, uploadId);
        try {

            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(null, httpHeaders);
            ResponseEntity<MonitoringResponseDTO> response = this.send(endpoint, HttpMethod.GET, requestEntity, MonitoringResponseDTO.class, createUriVariableEsitoUpload(category, uploadId));

            return manageResponseEsitoUpload(response);

        } catch (SOAPException | IOException | JAXBException e) {
            log.error("{}.callEsitoUpload - endpoint[{}] - uploadMonitoraggioIn[{}] ",
                    this.getClass().getName(), endpoint, uploadId, e);
        }
        return null;

    }

    private Map<String, String> createUriVariableEsitoUpload(String category, String uploadId) {
        Map<String, String> pathParams = new HashMap<>();

        pathParams.put("category", category);
        pathParams.put("uploadId", uploadId);
        pathParams.put("limit", "10");
        pathParams.put("offset", "0");
        pathParams.put("sort", "uploadId");
        pathParams.put("order", "asc");

        return pathParams;
    }


    private MonitoringResponseDTO manageResponseEsitoUpload(ResponseEntity<MonitoringResponseDTO> response) throws IOException, SOAPException, JAXBException {
        verifyHttpStatus(response);

        return extractBody(response).orElse(null);
    }


    public EsitoDownloadMds callDownloadFus(String idUpload, String percorsoFus) {

        String endpoint = this.gafBaseUrl + DOWNLOAD_FUS_ENDPOINT;

        log.debug("{}.callDownloadFus - endpoint[{}] - uploadRichiestaScartiAnomaliIn[{}] - percorsoFus[{}] - BEGIN",
                this.getClass().getName(), endpoint, idUpload, percorsoFus);
        try {
            log.info("URL GAF download FUS " + endpoint);


            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(null, httpHeaders);

            ResponseEntity<byte[]> response = this.send(endpoint, HttpMethod.GET, requestEntity, byte[].class, Map.of("uploadId", idUpload));

            return manageResponseDownloadFus(response, idUpload, percorsoFus);

        } catch (Exception e) {
            log.error("{}.callDownloadFus - endpoint[{}] - uploadRichiestaScartiAnomaliIn[{}] - percorsoFus[{}] ",
                    this.getClass().getName(), endpoint, idUpload, percorsoFus, e);
        }
        return null;

    }


        private EsitoDownloadMds manageResponseDownloadFus(ResponseEntity<byte[]> response, String idUpload, String percorsoFus) throws IOException, SOAPException, JAXBException {

            EsitoDownloadEnum esito = null;
            switch (response.getStatusCode()) {
                case OK: esito = EsitoDownloadEnum.DF01; break;
                case NO_CONTENT:
                case NOT_FOUND:esito = EsitoDownloadEnum.DF02; break;
                case FORBIDDEN:
                case UNAUTHORIZED: esito = EsitoDownloadEnum.AE00; break;
                case BAD_REQUEST:
                case METHOD_NOT_ALLOWED:
                case GATEWAY_TIMEOUT:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:esito = EsitoDownloadEnum.DF03; break;
                default: esito = EsitoDownloadEnum.DF99; break;
            }

            return EsitoDownloadMds.builder()
                    .withEsitoDownload(esito)
                    .withNomeFile(scriviAttachment(response, percorsoFus))
                    .withIdUpload(idUpload)
                    .build();
        }


    public String scriviAttachment(ResponseEntity<byte[]> response, String percorso) {
        log.debug("{}.scriviAttachment - percorso[{}] - BEGIN",
                this.getClass().getName(), percorso);
        String fileName = null;
        try {
                fileName = response.getHeaders().getContentDisposition().getFilename();
                File outputFile = new File(percorso + File.separator + fileName);
                FileUtils.writeByteArrayToFile(outputFile, response.getBody());
                log.debug("Scritto file allegato {}", outputFile.getName());

        } catch (IOException e) {
            log.error("{}.scriviAttachment - percorso[{}] ",
                    this.getClass().getName(), percorso, e);
        }
        return fileName;
    }


    private FileUploadAPIResponseDTO manageResponse(ResponseEntity<FileUploadAPIResponseDTO> response) throws IOException, SOAPException, JAXBException {
        verifyHttpStatus(response);

        return extractBody(response).orElse(null);
    }


    private <T> void verifyHttpStatus(ResponseEntity<T> response) {
        Optional.ofNullable(response).filter(r -> r.getStatusCode() != HttpStatus.OK).ifPresent(r -> {
            throw new ConnettoreMdsException(r.getStatusCode() + " - " + r.getBody(), null);
        });
    }

    private void verifyErrorCode(ResponseEntity<FileUploadAPIResponseDTO> response) {
        extractBody(response).filter(b -> StringUtils.isNotBlank(b.getErrorCode())).ifPresent(b -> {
            throw new ConnettoreMdsException(b.getErrorCode() + " - " + b.getMessage(), null);
        });
    }

    private <T> Optional<T> extractBody(ResponseEntity<T> response) {
        return Optional.ofNullable(response).map(HttpEntity::getBody);
    }

}
