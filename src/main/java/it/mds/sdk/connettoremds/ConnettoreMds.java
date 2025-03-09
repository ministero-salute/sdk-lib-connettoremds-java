/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds;

import it.mds.sdk.connettoremds.dispovig.webservice.bean.UploadFileResponse;
import it.mds.sdk.connettoremds.dpm.webservice.bean.SoggettoAlimentanteType;
import it.mds.sdk.connettoremds.dpm.webservice.bean.TipoAttoType;
import it.mds.sdk.connettoremds.dpm.webservice.bean.verifica.stato.DpmMdsResponse;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.gaf.webservices.bean.ResponseUploadFile;
import it.mds.sdk.connettoremds.modelli.ResponseDownload;
import it.mds.sdk.connettoremds.modelli.ResponseEsitoUpload;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public interface ConnettoreMds {

    public DpmMdsResponse invioTracciatoDonazionePostMortem (File xmlToMds, String idSoggettoAlimentante,
                                                             SoggettoAlimentanteType soggettoAlimentanteType,
                                                             TipoAttoType tipoAttoType, String idRun) throws ConnettoreMdsException;
    public DpmMdsResponse verificaElaborazioneDonazionePostMortem (String idSoggettoAlimentante,
                                                         SoggettoAlimentanteType soggettoAlimentanteType,String idRun) throws ConnettoreMdsException;

    public ResponseEsitoUpload getEsitoUpload (List<String> idsUpload, String category) throws ConnettoreMdsException;

    public ResponseDownload downloadFus (List<String> idsUpload) throws ConnettoreMdsException;

    public ResponseUploadFile invioTracciati (List<Path> tracciati, String categoriaFlusso, String nomeFlusso, String periodoRiferimento, String annoRiferimento) throws ConnettoreMdsException;

    public UploadFileResponse invioTracciatoDispovig (String nomefile) throws ConnettoreMdsException;
}
