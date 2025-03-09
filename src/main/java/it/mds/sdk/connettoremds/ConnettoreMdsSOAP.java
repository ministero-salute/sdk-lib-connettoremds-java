/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds;


import it.mds.sdk.connettoremds.dispovig.webservice.soap.DispoVigSoapGateway;
import it.mds.sdk.connettoremds.dpm.soap.DpmSoapGateway;
import it.mds.sdk.connettoremds.enums.EsitoDownloadEnum;
import it.mds.sdk.connettoremds.enums.EsitoElaborazioneEnum;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.gaf.webservices.bean.*;
import it.mds.sdk.connettoremds.gaf.webservices.soap.GafSoapGateway;
import it.mds.sdk.connettoremds.modelli.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component("connettoreMds")
@ConditionalOnProperty(name = "connettoreMds.type", havingValue = "SOAP", matchIfMissing = true)
public class ConnettoreMdsSOAP extends ConnettoreMdsAbstract implements ConnettoreMds {

    private final GafSoapGateway gafSoapGateway;


    @Autowired
    public ConnettoreMdsSOAP(@Qualifier("dpmSoapGateway") DpmSoapGateway dpmSoapGateway,
                             @Qualifier("gafSoapGateway") GafSoapGateway gafSoapGateway,
                             @Qualifier("dispoVigSoapGateway") DispoVigSoapGateway dispoVigSoapGateway) {
        super(dpmSoapGateway, dispoVigSoapGateway);
        this.gafSoapGateway = gafSoapGateway;
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
        URL endpoint = null;
        try {

            endpoint = new URL(config.getUrlGAF().getUrlWebserviceGAF());
            List<File> fileToSend = new ArrayList<>();

            InformazioniFlusso informazioniFlusso = gafSoapGateway.creaRequestInvioTracciati(tracciati, categoriaFlusso, nomeFlusso,
                    periodoRiferimento, annoRiferimento, fileToSend);

            //chiamata ministero
            ResponseUploadFile resp = gafSoapGateway.callInvioFlussi(endpoint, informazioniFlusso, fileToSend, config.getUserInvio().getUserInvioMds(), config.getPasswordInvio().getPasswordInvioMds());
            return resp;

        } catch (ConnettoreMdsException | IOException e) {
            //TODO rivedere le eccezioni
            log.error("{}.invioTracciati - tracciati[{}] - categoriaFlusso[{}] - nomeFlusso[{}] - periodoRiferimento[{}] - annoRiferimento[{}]",
                    this.getClass().getName(), tracciati.stream().map(obj -> "" + obj).collect(Collectors.joining("|")), categoriaFlusso, nomeFlusso, periodoRiferimento, annoRiferimento, e);
            throw new ConnettoreMdsException("Eccezione nella chiamata invio Tracciati" + e.getMessage(), e);
        }

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
        //creo request
        UploadMonitoraggioIn uploadMonitoraggioIn = new UploadMonitoraggioIn();
        ArrayOfXsdString listIdUpload = new ArrayOfXsdString();
        listIdUpload.getItem().addAll(idsUpload);
        uploadMonitoraggioIn.setIdentificativiUpload(listIdUpload);

        try {
            URL url = new URL(config.getUrlGAF().getUrlWebserviceGAF());
            //chiamata al ministero
            ResponseUploadXMLWithFile responseUploadXMLWithFile = gafSoapGateway.callEsitoUpload(url, uploadMonitoraggioIn,
                    config.getEsitiMx11().getPercorsoEsitimx11(),
                    config.getUserInvio().getUserInvioMds(), config.getPasswordInvio().getPasswordInvioMds());

            ResponseUploadXML responseUploadXML = responseUploadXMLWithFile.getResponseUploadXML();
            if (responseUploadXML != null) {
                List<String> listaNomeFile = responseUploadXMLWithFile.getNomiFile();
                ArrayOfUploadMonitoraggioOut arrayOfUploadMonitoraggioOut = responseUploadXML.getUploadMonitoraggio();
                List<EsitoElaborazioneMds> esiti = new ArrayList<>();

                if (arrayOfUploadMonitoraggioOut != null) {
                    List<UploadMonitoraggioOut> listaMonitoraggioOut = arrayOfUploadMonitoraggioOut.getItem();
                    for (UploadMonitoraggioOut out : listaMonitoraggioOut) {
                        String nomeFile = "";
                        for (String nome : listaNomeFile) {
                            if (nome.contains(out.getIdUpload())) {
                                nomeFile = config.getEsitiMx11().getPercorsoEsitimx11() + "/" + nome;
                            }
                        }

                        esiti.add(EsitoElaborazioneMds.builder()
                                .withEsitoElaborazione(EsitoElaborazioneEnum.valueOfCode(out.getEsitoElaborazione()))
                                .withIdUpload(out.getIdUpload())
                                .withNomeFile(nomeFile)
                                .build());
                    }
                }

                return ResponseEsitoUpload.builder()
                        .withErrorCode(responseUploadXML.getErrorCode())
                        .withErrorText(responseUploadXML.getErrorText())
                        .withPercorsoMx11(config.getEsitiMx11().getPercorsoEsitimx11())
                        .withEsiti(esiti)
                        .build();
            } else {
                throw new ConnettoreMdsException("Eccezione nella chiamata getEsitoUpload");
            }
        } catch (Throwable e) {
            log.error("{}.getEsitoUpload - idsUpload[{}] ", this.getClass().getName(), String.join("|", idsUpload), e);
            throw new ConnettoreMdsException("Eccezione nella chiamata getEsitoUpload " + e.getMessage());
        }
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
        UploadRichiestaScartiAnomaliIn uploadRichiestaScartiAnomaliIn = new UploadRichiestaScartiAnomaliIn();
        ArrayOfUploadScartiAnomaliElencoIn arrayOfUploadScartiAnomaliElencoIn = new ArrayOfUploadScartiAnomaliElencoIn();

        for (String idUpload : idsUpload) {
            UploadScartiAnomaliElencoIn uploadScartiAnomaliElencoIn = new UploadScartiAnomaliElencoIn();
            uploadScartiAnomaliElencoIn.setIdUpload(idUpload);
            uploadScartiAnomaliElencoIn.setTipoFile("X");
            arrayOfUploadScartiAnomaliElencoIn.getItem().add(uploadScartiAnomaliElencoIn);
        }
        uploadRichiestaScartiAnomaliIn.setElencoUploadRichiesta(arrayOfUploadScartiAnomaliElencoIn);

        try {
            // chiamata al ministero
            URL url = new URL(config.getUrlGAF().getUrlWebserviceGAF());
            //chiamata al ministero
            var respGaf = gafSoapGateway.callDownloadFus(url, uploadRichiestaScartiAnomaliIn,
                    config.getFus().getPercorsoFus(), config.getUserInvio().getUserInvioMds(), config.getPasswordInvio().getPasswordInvioMds());
            ResponseDwnldScartiAnomaliUpload responseDwnldScartiAnomaliUpload = respGaf.getResponseDwnldScartiAnomaliUpload();
            if (responseDwnldScartiAnomaliUpload != null) {

                List<UploadRichiestaScartiAnomaliOut> listaAnomaliOut = responseDwnldScartiAnomaliUpload.getElencoScartiAnomali().getItem();
                List<EsitoDownloadMds> esiti = new ArrayList<>();
                for (UploadRichiestaScartiAnomaliOut out : listaAnomaliOut) {
                    String nomeFile = "";
                    for (String file : respGaf.getNomiFile()) {
                        if (file.contains(out.getIdUpload())) {
                            nomeFile = config.getFus().getPercorsoFus() + "/" + file;
                            log.debug("Trovato file corrispondente all'idUpload {}", nomeFile);
                            break;
                        }
                    }
                    esiti.add(EsitoDownloadMds.builder()
                            .withEsitoDownload(EsitoDownloadEnum.valueOfCode(out.getEsitoElaborazione()))
                            .withTipoFile(out.getTipoFile())
                            .withIdUpload(out.getIdUpload())
                            .withNomeFile(nomeFile)
                            .build());

                }
                return ResponseDownload.builder()
                        .withErrorCode(responseDwnldScartiAnomaliUpload.getErrorCode())
                        .withErrorText(responseDwnldScartiAnomaliUpload.getErrorText())
                        .withEsitiDownload(esiti)
                        .build();
            } else {
                throw new ConnettoreMdsException("Eccezione nella chiamata downloadFus");
            }
        } catch (Throwable e) {
            log.error("{}.downloadFus - idsUpload[{}]", this.getClass().getName(), String.join("|", idsUpload), e);
            throw new ConnettoreMdsException("Eccezione nella chiamata downloadFus " + e.getMessage());
        }
    }

}
