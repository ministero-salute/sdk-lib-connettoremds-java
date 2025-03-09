/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds;


import it.mds.sdk.connettoremds.conf.ConfigurazioneConnettoreMds;
import it.mds.sdk.connettoremds.dispovig.webservice.bean.UploadFile;
import it.mds.sdk.connettoremds.dispovig.webservice.bean.UploadFileResponse;
import it.mds.sdk.connettoremds.dispovig.webservice.soap.DispoVigSoapGateway;
import it.mds.sdk.connettoremds.dpm.soap.DpmSoapGateway;
import it.mds.sdk.connettoremds.dpm.webservice.bean.DpmInvioXmlRequest;
import it.mds.sdk.connettoremds.dpm.webservice.bean.DpmVerificaStatoXmlRequest;
import it.mds.sdk.connettoremds.dpm.webservice.bean.SoggettoAlimentanteType;
import it.mds.sdk.connettoremds.dpm.webservice.bean.TipoAttoType;
import it.mds.sdk.connettoremds.dpm.webservice.bean.verifica.stato.DpmMdsResponse;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public abstract class ConnettoreMdsAbstract implements ConnettoreMds {

    protected final ConfigurazioneConnettoreMds config;
    protected final DpmSoapGateway dpmSoapGateway;
    protected final DispoVigSoapGateway dispoVigSoapGateway;

    public ConnettoreMdsAbstract(DpmSoapGateway dpmSoapGateway,
                                 DispoVigSoapGateway dispoVigSoapGateway) {
        this.config = new ConfigurazioneConnettoreMds();
        this.dpmSoapGateway = dpmSoapGateway;
        this.dispoVigSoapGateway = dispoVigSoapGateway;
    }


    /**
     * Metodo che invia il tracciato DPM al Mds
     */

    @Override
    public DpmMdsResponse invioTracciatoDonazionePostMortem(
            File xmlToMds,
            String idSoggettoAlimentante,
            SoggettoAlimentanteType soggettoAlimentanteType,
            TipoAttoType tipoAttoType,
            String idRun
    ) throws ConnettoreMdsException {
        log.debug("{}.invioTracciatoDonazionePostMortem - xmlToMds[{}] - idSoggettoAlimentante[{}] - soggettoAlimentanteType[{}] - tipoAttoType[{}] - BEGIN",
                this.getClass().getName(), xmlToMds, idSoggettoAlimentante, soggettoAlimentanteType, tipoAttoType);
        DpmInvioXmlRequest request = dpmSoapGateway.creaRequestInvioDpm(idSoggettoAlimentante, soggettoAlimentanteType, tipoAttoType, xmlToMds.getName());
        return dpmSoapGateway.callInvioDpm(
                request, config.getUrlDPM().getUrlWebserviceDPM(), xmlToMds, config.getUserInvioDpm().getUserInvioMdsDpm(), config.getPasswordInvioDpm().getPasswordInvioMdsDpm(), idRun
        );

    }

    /**
     * Metodo che verifica lo stato di elaborazione del file DPM inviato a MdS
     */
    @Override
    public DpmMdsResponse verificaElaborazioneDonazionePostMortem(String idSoggettoAlimentante,
                                                                  SoggettoAlimentanteType soggettoAlimentanteType,String idRun) throws ConnettoreMdsException {
        log.debug("{}.verificaElaborazioneDonazionePostMortem - idSoggettoAlimentante[{}] - soggettoAlimentanteType[{}] - BEGIN",
                this.getClass().getName(), idSoggettoAlimentante, soggettoAlimentanteType);
        DpmVerificaStatoXmlRequest request = dpmSoapGateway.creaRequestVerificaDpm(idSoggettoAlimentante, soggettoAlimentanteType);
        return dpmSoapGateway.callVerificaDpm(request, config.getUrlDPM().getUrlWebserviceDPM(), config.getUserInvioDpm().getUserInvioMdsDpm(), config.getPasswordInvioDpm().getPasswordInvioMdsDpm(), idRun);
    }

    /**
     * Metodo per invio file dispovig a mds
     * @param nomeFile
     * @return
     * @throws ConnettoreMdsException
     */
    @Override
    public UploadFileResponse invioTracciatoDispovig(String nomeFile) throws ConnettoreMdsException {
        log.debug("{}.invioTracciatoDispovig - tracciato[{}] - BEGIN", this.getClass().getName(), nomeFile);
        UploadFile uploadFileRequest = dispoVigSoapGateway.creaRequestInvioDispovig(nomeFile,config.getXmlOutput().getPercorso());
        return  dispoVigSoapGateway.callUploadFileDispovig(uploadFileRequest,config.getUrlDispovig().getUrlWebserviceDispovig(),
                config.getUserInvioDispovig().getUserInvioMdsDispovig(), config.getPasswordInvioDispovig().getPasswordInvioMdsDispovig());
    }


}
