//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per allegatiType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="allegatiType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="allegato" type="{http://be.dpm.mds.it}allegatoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "allegatiType", propOrder = {
    "allegato"
})
public class AllegatiType {

    @XmlElement(required = true)
    protected AllegatoType allegato;

    /**
     * Recupera il valore della proprietà allegato.
     * 
     * @return
     *     possible object is
     *     {@link AllegatoType }
     *     
     */
    public AllegatoType getAllegato() {
        return allegato;
    }

    /**
     * Imposta il valore della proprietà allegato.
     * 
     * @param value
     *     allowed object is
     *     {@link AllegatoType }
     *     
     */
    public void setAllegato(AllegatoType value) {
        this.allegato = value;
    }

}
