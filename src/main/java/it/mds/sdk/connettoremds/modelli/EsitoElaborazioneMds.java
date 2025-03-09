/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.modelli;

import it.mds.sdk.connettoremds.enums.EsitoElaborazioneEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;


@Builder(setterPrefix = "with")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EsitoElaborazioneMds {
    private String idUpload;
    private EsitoElaborazioneEnum esitoElaborazione;
    private String nomeFile;

}
