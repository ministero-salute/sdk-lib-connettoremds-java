package it.mds.sdk.connettoremds.enums;

import java.util.HashMap;
import java.util.Map;

public enum EsitoElaborazioneEnum {

    AE00("AE00", "Errore di autenticazione al servizio"),
    MX00("MX00","Upload non elaborato"),
    MX01("MX01","Upload o fornitura richiesta non esistente"),
    MX11("MX11","Struttura del file XML non conforme alle specifiche"),
    MX20("MX20","Operazione completata senza scarti e senza anomalie"),
    MX21("MX21","Operazione completata con anomalie"),
    MX22("MX22","Operazione completata con scarti"),
    MX23("MX23","Incongruenza con le informazioni di upload"),
    MX99("MX99","Errore generico dell’operation");

    private String codiceErrore;
    private String descrizioneErrore;

    private static final Map<String, EsitoElaborazioneEnum> BY_CODE = new HashMap<>();
    private static final Map<String, EsitoElaborazioneEnum> BY_DESC = new HashMap<>();

    public String getCodiceErrore() {
        return codiceErrore;
    }

    public String getDescrizioneErrore() {
        return descrizioneErrore;
    }

    private EsitoElaborazioneEnum(String codiceErrore, String descrizioneErrore) {
        this.codiceErrore = codiceErrore;
        this.descrizioneErrore = descrizioneErrore;
    }

    static {
        for (EsitoElaborazioneEnum e : values()) {
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


