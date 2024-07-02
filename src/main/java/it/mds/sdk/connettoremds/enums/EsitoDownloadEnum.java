/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.enums;

import java.util.HashMap;
import java.util.Map;

public enum EsitoDownloadEnum {

    AE00("AE00", "Errore di autenticazione al servizio"),
    DF01("DF01","File restituito"),
    DF02("DF02","Non individuato alcun file per l’upload indicato"),
    DF03("DF03","Errore durante l’invio del pacchetto"),
    DF99("DF99","Errore generico dell’operation");

    private String codiceErrore;
    private String descrizioneErrore;

    private static final Map<String, EsitoDownloadEnum> BY_CODE = new HashMap<>();
    private static final Map<String, EsitoDownloadEnum> BY_DESC = new HashMap<>();

    public String getCodiceErrore() {
        return codiceErrore;
    }

    public String getDescrizioneErrore() {
        return descrizioneErrore;
    }

    private EsitoDownloadEnum(String codiceErrore, String descrizioneErrore) {
        this.codiceErrore = codiceErrore;
        this.descrizioneErrore = descrizioneErrore;
    }

    static {
        for (EsitoDownloadEnum e : values()) {
            BY_CODE.put(e.codiceErrore, e);
            BY_DESC.put(e.descrizioneErrore, e);
        }
    }

    public static EsitoDownloadEnum valueOfCode(String codiceErrore) {
        return BY_CODE.get(codiceErrore);
    }

    public static EsitoDownloadEnum valueOfDescription(String descrizioneErrore) {
        return BY_DESC.get(descrizioneErrore);
    }
}


