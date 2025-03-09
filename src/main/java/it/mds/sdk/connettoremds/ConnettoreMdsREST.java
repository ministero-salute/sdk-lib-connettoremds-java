/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds;


import it.mds.sdk.connettoremds.dispovig.webservice.soap.DispoVigSoapGateway;
import it.mds.sdk.connettoremds.dpm.soap.DpmSoapGateway;
import it.mds.sdk.connettoremds.enums.EsitoElaborazioneEnum;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.gaf.rest.GafRestGateway;
import it.mds.sdk.connettoremds.gaf.rest.request.InformazioniFlusso;
import it.mds.sdk.connettoremds.gaf.rest.response.FileUploadAPIResponseDTO;
import it.mds.sdk.connettoremds.gaf.rest.response.MonitorDTO;
import it.mds.sdk.connettoremds.gaf.rest.response.MonitoringResponseDTO;
import it.mds.sdk.connettoremds.gaf.webservices.bean.ArrayOfUploadEsito;
import it.mds.sdk.connettoremds.gaf.webservices.bean.ResponseUploadFile;
import it.mds.sdk.connettoremds.gaf.webservices.bean.UploadEsito;
import it.mds.sdk.connettoremds.modelli.EsitoDownloadMds;
import it.mds.sdk.connettoremds.modelli.EsitoElaborazioneMds;
import it.mds.sdk.connettoremds.modelli.ResponseDownload;
import it.mds.sdk.connettoremds.modelli.ResponseEsitoUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component("connettoreMds")
@ConditionalOnProperty(name = "connettoreMds.type", havingValue = "REST", matchIfMissing = false)
public class ConnettoreMdsREST extends ConnettoreMdsAbstract implements ConnettoreMds {

    private final GafRestGateway gafRestGateway;

    @Autowired
    public ConnettoreMdsREST(@Qualifier("dpmSoapGateway") DpmSoapGateway dpmSoapGateway,
                             GafRestGateway gafRestGateway,
                             @Qualifier("dispoVigSoapGateway") DispoVigSoapGateway dispoVigSoapGateway) {
        super(dpmSoapGateway, dispoVigSoapGateway);
        this.gafRestGateway = gafRestGateway;

    }

    /**
     * Metodo che prende i file (Path) dei tracciati da inviare a Mds e crea la request SOAP ad hoc per il servizio da chiamare
     *
     * @param tracciati
     * @return Una stringa che rappresenta IdUpload del Ministero
     */
    @Override
    public ResponseUploadFile invioTracciati(List<Path> tracciati, String categoriaFlusso,
                                             String nomeFlusso, String periodoRiferimento,
                                             String annoRiferimento) throws ConnettoreMdsException {
        log.debug("{}.invioTracciati - tracciati[{}] - categoriaFlusso[{}] - nomeFlusso[{}] - periodoRiferimento[{}] - annoRiferimento[{}] - BEGIN",
                this.getClass().getName(), tracciati.stream().map(obj -> "" + obj).collect(Collectors.joining("|")), categoriaFlusso, nomeFlusso, periodoRiferimento, annoRiferimento);
        try {
            InformazioniFlusso infoFlusso = new InformazioniFlusso(categoriaFlusso, nomeFlusso, periodoRiferimento, annoRiferimento);

            List<UploadEsito> esiti = Optional.ofNullable(tracciati).orElse(Collections.emptyList())
                    .stream().map(p -> sendFile(infoFlusso, p))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            ArrayOfUploadEsito arrayOfUploadEsito = new ArrayOfUploadEsito();
            arrayOfUploadEsito.getItem().addAll(esiti);
            ResponseUploadFile responseUploadFile = new ResponseUploadFile();
            responseUploadFile.setListaEsitiUpload(arrayOfUploadEsito);

            return responseUploadFile;

        } catch (ConnettoreMdsException e) {
            log.error("{}.invioTracciati - tracciati[{}] - categoriaFlusso[{}] - nomeFlusso[{}] - periodoRiferimento[{}] - annoRiferimento[{}]",
                    this.getClass().getName(), tracciati.stream().map(obj -> "" + obj).collect(Collectors.joining("|")), categoriaFlusso, nomeFlusso, periodoRiferimento, annoRiferimento, e);
            throw new ConnettoreMdsException("Eccezione nella chiamata invio Tracciati" + e.getMessage(), e);
        }


    }

    UploadEsito sendFile(InformazioniFlusso infoFlusso, Path p) {

        try {
            FileUploadAPIResponseDTO resp = gafRestGateway.callInvioFlussi(infoFlusso, p);
            return map(resp, p);
        } catch (Exception e) {
            return map(e, p);
        }

    }


    private UploadEsito map(FileUploadAPIResponseDTO source, Path p) {
        if (source == null) {
            return null;
        }

        UploadEsito target = new UploadEsito();
        target.setEsito(source.getResult());
        target.setNomeFile(p.getFileName().toString());
        target.setIdUpload(source.getUploadId());
        return target;
    }

    private UploadEsito map(Exception source, Path p) {
        if (source == null) {
            return null;
        }

        UploadEsito target = new UploadEsito();
        target.setEsito(source.getMessage());
        target.setNomeFile(p.getFileName().toString());

        return target;
    }


    /**
     * Metodo che chiama Mds per sapere esito delle elaborazioni passate in input
     *
     * @param idsUpload
     * @return ResponseEsitoUpload
     */
    @Override
    public ResponseEsitoUpload getEsitoUpload(List<String> idsUpload, String category) throws ConnettoreMdsException {

        log.debug("{}.getEsitoUpload - idsUpload[{}] - BEGIN", this.getClass().getName(), String.join("|", idsUpload));

        try {
            //chiamata al ministero
            List<EsitoElaborazioneMds> esiti = Optional.ofNullable(idsUpload).orElse(Collections.emptyList())
                    .stream().map(uploadId -> callEsitoUpload(uploadId, category))
                    .filter(Objects::nonNull)
                    .flatMap(Collection::stream)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            if (esiti.isEmpty()) {
                throw new ConnettoreMdsException("Eccezione nella chiamata getEsitoUpload");
            }


            return ResponseEsitoUpload.builder()
                    .withPercorsoMx11(config.getEsitiMx11().getPercorsoEsitimx11())
                    .withEsiti(esiti)
                    .build();

        } catch (Throwable e) {
            log.error("{}.getEsitoUpload - idsUpload[{}] ", this.getClass().getName(), String.join("|", idsUpload), e);
            throw new ConnettoreMdsException("Eccezione nella chiamata getEsitoUpload " + e.getMessage());
        }
    }

    private List<EsitoElaborazioneMds> callEsitoUpload(String uploadId, String category) {
        try {
            return map(gafRestGateway.callEsitoUpload(uploadId, category));
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
        return null;

    }

    private List<EsitoElaborazioneMds> map(MonitoringResponseDTO source) {
        if (source == null) {
            return null;
        }

        return Optional.of(source)
                .map(MonitoringResponseDTO::getUploadList).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(this::map)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private EsitoElaborazioneMds map(MonitorDTO source) {
        if (source == null) {
            return null;
        }

        Optional<MonitorDTO> opSource = Optional.of(source);

        EsitoElaborazioneMds target = new EsitoElaborazioneMds();
        opSource.map(MonitorDTO::getFileName).map(filName -> config.getEsitiMx11().getPercorsoEsitimx11() + "/" + filName).ifPresent(target::setNomeFile);
        opSource.map(MonitorDTO::getIdUpload).ifPresent(target::setIdUpload);
        opSource.map(MonitorDTO::getElabState).map(Object::toString).map(elabState -> new EsitoElaborazioneEnum(elabState, source.getElabStateDesc())).ifPresent(target::setEsitoElaborazione);

//        TODO review, use details?
//        MonitorDTO monitorDTO;
//        monitorDTO.
//
//
//        new EsitoElaborazioneEnum("AE00", "Errore di autenticazione al servizio"),
//                new EsitoElaborazioneEnum("MX00","Upload non elaborato"),
//                new EsitoElaborazioneEnum("MX01","Upload o fornitura richiesta non esistente"),
//                new EsitoElaborazioneEnum("MX11","Struttura del file XML non conforme alle specifiche"),
//                new EsitoElaborazioneEnum("MX20","Operazione completata senza scarti e senza anomalie"),
//                new EsitoElaborazioneEnum("MX21","Operazione completata con anomalie"),
//                new EsitoElaborazioneEnum("MX22","Operazione completata con scarti"),
//                new EsitoElaborazioneEnum("MX23","Incongruenza con le informazioni di upload"),
//                new EsitoElaborazioneEnum("MX99","Errore generico dell’operation")
//
        return target;
    }

    /**
     * Metodo che chiama Mds per download del FUS delle elaborazioni passate in input
     *
     * @param idsUpload
     * @return
     */
    @Override
    public ResponseDownload downloadFus(List<String> idsUpload) throws ConnettoreMdsException {
        log.debug("{}.downloadFus - idsUpload[{}] - BEGIN", this.getClass().getName(), String.join("|", idsUpload));
        //creo request

        try {
            List<EsitoDownloadMds> esiti = Optional.ofNullable(idsUpload)
                    .map(Collection::stream).orElse(Stream.empty())
                    .map(idUpload -> gafRestGateway.callDownloadFus(idUpload, config.getFus().getPercorsoFus()))
                    .collect(Collectors.toList());

            if (esiti.isEmpty()) {
                throw new ConnettoreMdsException("Eccezione nella chiamata downloadFus");
            }

            return ResponseDownload.builder()
                    .withEsitiDownload(esiti)
                    .build();

        } catch (Throwable e) {
            log.error("{}.downloadFus - idsUpload[{}]", this.getClass().getName(), String.join("|", idsUpload), e);
            throw new ConnettoreMdsException("Eccezione nella chiamata downloadFus " + e.getMessage());
        }
    }


}
