package it.mds.sdk.connettoremds.modelli;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder(setterPrefix = "with")
public class ResponseEsitoUpload {
    String errorCode;
    String errorText;
    List<EsitoElaborazioneMds> esiti;
    String percorsoMx11;


    public ResponseEsitoUpload(String errorCode,
                               String errorText,
                               List<EsitoElaborazioneMds> esiti,
                               String percorsoMx11) {
        this.errorCode = errorCode;
        this.errorText = errorText;
        this.esiti = esiti;
        this.percorsoMx11 = percorsoMx11;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public void setEsiti(List<EsitoElaborazioneMds> esiti) {
        this.esiti = esiti;
    }

    public List<EsitoElaborazioneMds> getEsiti() {
        if (esiti == null) {
            esiti = new ArrayList<>();
        }
        return this.esiti;
    }

    public String getPercorsoMx11() {
        return percorsoMx11;
    }
    public void setPercorsoMx11(String percorsoMx11) {
        this.percorsoMx11 = percorsoMx11;
    }
}
