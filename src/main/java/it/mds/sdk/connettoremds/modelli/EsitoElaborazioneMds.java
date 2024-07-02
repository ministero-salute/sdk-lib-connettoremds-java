/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.modelli;

import it.mds.sdk.connettoremds.enums.EsitoElaborazioneEnum;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class EsitoElaborazioneMds {
    private String idUpload;
    private EsitoElaborazioneEnum esitoElaborazione;
    private String nomeFile;

}
