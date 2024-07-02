/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.modelli;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder(setterPrefix = "with")
public class ResponseDownload {
    String errorCode;
    String errorText;
    List<EsitoDownloadMds> esitiDownload;



    public ResponseDownload(String errorCode,
                               String errorText,
                               List<EsitoDownloadMds> esitiDownload) {
        this.errorCode = errorCode;
        this.errorText = errorText;
        this.esitiDownload = esitiDownload;
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

    public void setEsiti(List<EsitoDownloadMds> esiti) {
        this.esitiDownload = esiti;
    }

    public List<EsitoDownloadMds> getEsiti() {
        if (esitiDownload == null) {
            esitiDownload = new ArrayList<>();
        }
        return this.esitiDownload;
    }


}
