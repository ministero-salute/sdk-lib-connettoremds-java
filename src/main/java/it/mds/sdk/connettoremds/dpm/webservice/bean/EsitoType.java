//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per esitoType.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <pre>
 * &lt;simpleType name="esitoType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PRESA_IN_CARICO"/&gt;
 *     &lt;enumeration value="IN_LAVORAZIONE"/&gt;
 *     &lt;enumeration value="EVASA_OK"/&gt;
 *     &lt;enumeration value="EVASA_CON_ERRORI"/&gt;
 *     &lt;enumeration value="EVASA_XML_ERRATO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "esitoType")
@XmlEnum
public enum EsitoType {

    PRESA_IN_CARICO,
    IN_LAVORAZIONE,
    EVASA_OK,
    EVASA_CON_ERRORI,
    EVASA_XML_ERRATO;

    public String value() {
        return name();
    }

    public static EsitoType fromValue(String v) {
        return valueOf(v);
    }

}
