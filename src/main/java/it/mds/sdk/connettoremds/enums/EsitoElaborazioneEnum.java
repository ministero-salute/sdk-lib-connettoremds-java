/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EsitoElaborazioneEnum {

    private static final List<EsitoElaborazioneEnum> ESITI = List.of(
            new EsitoElaborazioneEnum("AE00", "Errore di autenticazione al servizio"),
            new EsitoElaborazioneEnum("MX00","Upload non elaborato"),
            new EsitoElaborazioneEnum("MX01","Upload o fornitura richiesta non esistente"),
            new EsitoElaborazioneEnum("MX11","Struttura del file XML non conforme alle specifiche"),
            new EsitoElaborazioneEnum("MX20","Operazione completata senza scarti e senza anomalie"),
            new EsitoElaborazioneEnum("MX21","Operazione completata con anomalie"),
            new EsitoElaborazioneEnum("MX22","Operazione completata con scarti"),
            new EsitoElaborazioneEnum("MX23","Incongruenza con le informazioni di upload"),
            new EsitoElaborazioneEnum("MX99","Errore generico dell’operation")
    );

    private String codiceErrore;
    private String descrizioneErrore;

    private static final Map<String, EsitoElaborazioneEnum> BY_CODE = new HashMap<>();
    private static final Map<String, EsitoElaborazioneEnum> BY_DESC = new HashMap<>();

    static {
        for (EsitoElaborazioneEnum e : ESITI) {
            BY_CODE.put(e.codiceErrore, e);
            BY_DESC.put(e.descrizioneErrore, e);
        }
    }

    public static EsitoElaborazioneEnum valueOfCode(String codiceErrore) {
        return BY_CODE.get(codiceErrore);
    }

    public static EsitoElaborazioneEnum valueOfDescription(String descrizioneErrore) {
        return BY_DESC.get(descrizioneErrore);
    }
}


