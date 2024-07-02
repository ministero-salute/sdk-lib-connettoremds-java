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
 * <p>Classe Java per dpmVerificaStatoType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dpmVerificaStatoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identificativoSoggettoAlimentante" type="{http://be.dpm.mds.it}identificativoSoggettoAlimentanteType"/&gt;
 *         &lt;element name="soggettoAlimentante" type="{http://be.dpm.mds.it}soggettoAlimentanteType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dpmVerificaStatoType", propOrder = {
    "identificativoSoggettoAlimentante",
    "soggettoAlimentante"
})
public class DpmVerificaStatoType {

    @XmlElement(required = true)
    protected String identificativoSoggettoAlimentante;
    @XmlElement(required = true)
    protected SoggettoAlimentanteType soggettoAlimentante;

    /**
     * Recupera il valore della proprietà identificativoSoggettoAlimentante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoSoggettoAlimentante() {
        return identificativoSoggettoAlimentante;
    }

    /**
     * Imposta il valore della proprietà identificativoSoggettoAlimentante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoSoggettoAlimentante(String value) {
        this.identificativoSoggettoAlimentante = value;
    }

    /**
     * Recupera il valore della proprietà soggettoAlimentante.
     * 
     * @return
     *     possible object is
     *     {@link SoggettoAlimentanteType }
     *     
     */
    public SoggettoAlimentanteType getSoggettoAlimentante() {
        return soggettoAlimentante;
    }

    /**
     * Imposta il valore della proprietà soggettoAlimentante.
     * 
     * @param value
     *     allowed object is
     *     {@link SoggettoAlimentanteType }
     *     
     */
    public void setSoggettoAlimentante(SoggettoAlimentanteType value) {
        this.soggettoAlimentante = value;
    }

}
