package it.mds.sdk.connettoremds.modelli;

import it.mds.sdk.connettoremds.enums.EsitoDownloadEnum;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class EsitoDownloadMds {
    String idUpload;
    String tipoFile;
    EsitoDownloadEnum esitoDownload;
    String nomeFile;

}
