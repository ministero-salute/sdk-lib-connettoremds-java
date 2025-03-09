/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.gaf.webservices.soap;

import it.mds.sdk.connettoremds.RequestUtils;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.gaf.webservices.bean.*;
import it.mds.sdk.connettoremds.modelli.ResponseDwnldScartiAnomaliUploadWithFile;
import it.mds.sdk.connettoremds.modelli.ResponseUploadXMLWithFile;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Component("gafSoapGateway")
public class GafSoapGateway {




    public InformazioniFlusso creaRequestInvioTracciati(List<Path> tracciati,
                                                        String categoriaFlusso,
                                                        String nomeFlusso,
                                                        String periodoRiferimento,
                                                        String annoRiferimento,
                                                        List<File> fileToSend
                                                        //,
                                                        //String percorsoTracciatiGaf
    ) throws ConnettoreMdsException {
        log.debug("{}.creaRequestInvioTracciati - tracciati[{}] - categoriaFlusso[{}] - periodoRiferimento[{}]  - annoRiferimento[{}]  - fileToSend[{}] - BEGIN",
                this.getClass().getName(), tracciati, categoriaFlusso, periodoRiferimento, annoRiferimento, fileToSend.stream().map(obj -> "" + obj.getPath()).collect(Collectors.joining("|")));
        //creo la request per invio
        InformazioniFlusso informazioniFlusso = new InformazioniFlusso();
        informazioniFlusso.setCategoriaFlussi(categoriaFlusso);
        informazioniFlusso.setAnnoRiferimento(annoRiferimento);
        informazioniFlusso.setPeriodoRiferimento(periodoRiferimento);
        ArrayOfFileUploadInfo arrayOfFileUploadInfo = new ArrayOfFileUploadInfo();

        List<FileUploadInfo> fileUploadInfoList = new ArrayList<>();

        for (Path tracciato : tracciati) {
            String nomeFlussoInvio = RequestUtils.nomeFlussoInvio(categoriaFlusso, nomeFlusso, tracciato);

            File f = tracciato.toFile();
            fileToSend.add(f);
            FileUploadInfo fileUploadInfo = new FileUploadInfo();
            fileUploadInfo.setNomeFile(f.getName());
            fileUploadInfo.setNomeFlusso(nomeFlussoInvio);
            fileUploadInfoList.add(fileUploadInfo);

        }
        arrayOfFileUploadInfo.getItem().addAll(fileUploadInfoList);
        informazioniFlusso.setFileUpload(arrayOfFileUploadInfo);
        return informazioniFlusso;
    }

    public ResponseUploadFile callInvioFlussi(URL endpoint, InformazioniFlusso informazioniFlusso, List<File> fileToSend, String user, String password) throws ConnettoreMdsException {
        log.debug("{}.callInvioFlussi - endpoint[{}] - informazioniFlusso[{}] - fileToSend[{}] - BEGIN",
                this.getClass().getName(), endpoint.getPath(), informazioniFlusso.toString(), fileToSend.stream().map(obj -> "" + obj.getPath()).collect(Collectors.joining("|")));
        try {
            log.info("URL GAF invio " + endpoint.toString());
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            // SOAP Header
            soapMessage.getMimeHeaders().addHeader("Content-Type", "multipart/related;");
            SOAPHeader header = soapMessage.getSOAPHeader();
            createHeaderEnvelope(header, user, password);
            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            JAXBContext jc = JAXBContextFactory.createContext(new Class[]{InformazioniFlusso.class}, null);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(informazioniFlusso, soapBody);
            //Attachment
            for (File fileTracciato : fileToSend) {
                AttachmentPart attachment = soapMessage.createAttachmentPart();
                try (InputStream targetStream = new FileInputStream(fileTracciato)) {
                    attachment.setRawContent(targetStream, Files.probeContentType(fileTracciato.toPath()));
                    attachment.setContentId(fileTracciato.getName());
                    soapMessage.addAttachmentPart(attachment);
                }

            }

            soapMessage.saveChanges();

            logSOAPMessage(soapMessage);

            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();
            SOAPMessage response = connection.call(soapMessage, endpoint);

            log.info("Response Mds invio Flussi");
            logSOAPMessage(response);

            SOAPBody soapBodyResponse = response.getSOAPBody();


            JAXBContext jcR = JAXBContextFactory.createContext(new Class[]{ResponseUploadFile.class}, null);
            Unmarshaller unmarshaller = jcR.createUnmarshaller();
            connection.close();
            return (ResponseUploadFile) unmarshaller.unmarshal(soapBodyResponse.extractContentAsDocument());

        } catch (SOAPException | IOException | JAXBException e) {
            log.error("{}.callInvioFlussi - endpoint[{}] - informazioniFlusso[{}] - fileToSend[{}]",
                    this.getClass().getName(), endpoint.getPath(), informazioniFlusso.toString(), fileToSend.stream().map(obj -> "" + obj.getPath()).collect(Collectors.joining("|")),  e);
            throw new ConnettoreMdsException("Errore nella chiamata al ministero " + e.getMessage(), e);
        }
    }

    public List<String> scriviAttachment(SOAPMessage soapMessage, String percorso) {
        log.debug("{}.scriviAttachment - percorso[{}] - BEGIN",
                this.getClass().getName(),  percorso);
        List<String> nomiFileList = new ArrayList<>();
        log.debug("Numero allegati presenti nella risposta {}",soapMessage.countAttachments());
        Iterator<AttachmentPart> iterator = soapMessage.getAttachments();
        try {
            while (iterator.hasNext()) {
                AttachmentPart attachment = iterator.next();
                String fileName = attachment.getContentId().replace("<", "").replace(">", "");
                File outputFile = new File(percorso+ File.separator+fileName);
                FileUtils.writeByteArrayToFile(outputFile, attachment.getRawContentBytes());
                log.debug("Scritto file allegato {}", outputFile.getName());
                nomiFileList.add(fileName);
            }

        } catch(SOAPException | IOException e) {
            log.error("{}.scriviAttachment - percorso[{}] ",
                    this.getClass().getName(), percorso, e);
        }
        return nomiFileList;
    }

    public ResponseUploadXMLWithFile callEsitoUpload(URL endpoint, UploadMonitoraggioIn uploadMonitoraggioIn,
                                                     String percorsoMx11, String user, String password) {
        log.debug("{}.callEsitoUpload - endpoint[{}] - uploadMonitoraggioIn[{}] - percorsoMx11[{}] - BEGIN",
                this.getClass().getName(), endpoint.getPath(), uploadMonitoraggioIn, percorsoMx11);
        try {
            log.info("URL GAF esitoUpload" + endpoint.toString());
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            // SOAP Header
            soapMessage.getMimeHeaders().addHeader("Content-Type", "multipart/related;");
            SOAPHeader header = soapMessage.getSOAPHeader();
            createHeaderEnvelope(header, user, password);
            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            JAXBContext jc = JAXBContextFactory.createContext(new Class[]{UploadMonitoraggioIn.class}, null);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(uploadMonitoraggioIn, soapBody);
            soapMessage.saveChanges();

            logSOAPMessage(soapMessage);

            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();
            SOAPMessage response = connection.call(soapMessage, endpoint);

            log.info("Response Mds Esito Upload");
            logSOAPMessage(response);

            SOAPBody soapBodyResponse = response.getSOAPBody();

            List<String> fileNameList = scriviAttachment(response, percorsoMx11);

            JAXBContext jcR = JAXBContextFactory.createContext(new Class[]{ResponseUploadXML.class}, null);
            Unmarshaller unmarshaller = jcR.createUnmarshaller();
            connection.close();
            var responseXML = (ResponseUploadXML) unmarshaller.unmarshal(soapBodyResponse.extractContentAsDocument());
            return new ResponseUploadXMLWithFile(responseXML, fileNameList);

        } catch (SOAPException | IOException | JAXBException e) {
            log.error("{}.callEsitoUpload - endpoint[{}] - uploadMonitoraggioIn[{}] - percorsoMx11[{}] ",
                    this.getClass().getName(), endpoint.getPath(), uploadMonitoraggioIn, percorsoMx11, e);
        }
        return null;

    }

    public ResponseDwnldScartiAnomaliUploadWithFile callDownloadFus(URL endpoint,
                                                                    UploadRichiestaScartiAnomaliIn uploadRichiestaScartiAnomaliIn, String percorsoFus, String user, String password) {
        log.debug("{}.callDownloadFus - endpoint[{}] - uploadRichiestaScartiAnomaliIn[{}] - percorsoFus[{}] - BEGIN",
                this.getClass().getName(), endpoint.getPath(), uploadRichiestaScartiAnomaliIn, percorsoFus);
        try {
            log.info("URL GAF download FUS " + endpoint.toString());
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            // SOAP Header
            soapMessage.getMimeHeaders().addHeader("Content-Type", "multipart/related;");
            SOAPHeader header = soapMessage.getSOAPHeader();
            createHeaderEnvelope(header, user, password);
            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            JAXBContext jc = JAXBContextFactory.createContext(new Class[]{UploadRichiestaScartiAnomaliIn.class}, null);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(uploadRichiestaScartiAnomaliIn, soapBody);
            soapMessage.saveChanges();

            logSOAPMessage(soapMessage);

            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();
            SOAPMessage response = connection.call(soapMessage, endpoint);

            log.info("Response Mds download FUS");
            logSOAPMessage(response);
            SOAPBody soapBodyResponse = response.getSOAPBody();
            List<String> nomeFileAttach = scriviAttachment(response, percorsoFus);
            log.debug("Attachment scritti scaricati dal MDS {}", nomeFileAttach);
            JAXBContext jcR = JAXBContextFactory.createContext(new Class[]{ResponseDwnldScartiAnomaliUpload.class}, null);
            Unmarshaller unmarshaller = jcR.createUnmarshaller();
            connection.close();
            var resp =
                    (ResponseDwnldScartiAnomaliUpload) unmarshaller.unmarshal(soapBodyResponse.extractContentAsDocument());
            ResponseDwnldScartiAnomaliUploadWithFile respWithFile = new ResponseDwnldScartiAnomaliUploadWithFile(resp
                    , nomeFileAttach);
            return respWithFile;

        } catch (SOAPException | JAXBException | IOException e) {
            log.error("{}.callDownloadFus - endpoint[{}] - uploadRichiestaScartiAnomaliIn[{}] - percorsoFus[{}] ",
                    this.getClass().getName(), endpoint.getPath(), uploadRichiestaScartiAnomaliIn, percorsoFus, e);
        }
        return null;

    }


    private void createHeaderEnvelope(SOAPHeader header, String user, String passwordMds) {
        log.debug("{}.createHeaderEnvelope - BEGIN",
                this.getClass().getName());
        SOAPElement security = null;
        String creatTime = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
        try {
            security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

            SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
            usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            usernameToken.addAttribute(new QName("wsu:Id"), "UsernameToken-4");
            SOAPElement username = usernameToken.addChildElement("Username", "wsse");
            username.addTextNode(user);

            @SuppressWarnings("squid:S2068")
            SOAPElement password = usernameToken.addChildElement("Password", "wsse");
            password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

            password.addTextNode(passwordMds);

            SOAPElement created = usernameToken.addChildElement("Created", "wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

            created.addTextNode(creatTime);

        } catch (SOAPException e) {
            log.error("{}.createHeaderEnvelope", this.getClass().getName(), e);
        }
    }

    private void logSOAPMessage(SOAPMessage message) throws SOAPException, IOException {
        log.debug("{}.logSOAPMessage - BEGIN", this.getClass().getName());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        message.writeTo(bout);
        String msg = bout.toString(StandardCharsets.UTF_8);
        try {
            @SuppressWarnings("squid:S5852")
            Pattern patternSecurity = Pattern.compile("<wsse:Security.*?>(.*?)</wsse:Security>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = patternSecurity.matcher(msg);
            boolean matchFound = matcher.find();
            if (matchFound) {
                String toBeReplaced = matcher.group(1);
                log.info(":: Logging SOAP Message :: " + msg.replace(toBeReplaced,"*****"));
            }else{
                log.info(":: Logging SOAP Message :: " + msg);
            }
        }catch (Exception e){
            log.error("Errore durante la sostituzione del messaggio SOAP", e);
        }
    }








}
