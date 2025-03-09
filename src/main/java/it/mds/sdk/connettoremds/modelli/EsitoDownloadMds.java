/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.modelli;

import it.mds.sdk.connettoremds.enums.EsitoDownloadEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class EsitoDownloadMds {
    String idUpload;
    String tipoFile;
    EsitoDownloadEnum esitoDownload;
    String nomeFile;

}
