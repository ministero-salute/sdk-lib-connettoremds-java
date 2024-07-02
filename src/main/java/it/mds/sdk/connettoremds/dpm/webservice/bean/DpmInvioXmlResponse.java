//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dpmStatoContainer" type="{http://be.dpm.mds.it}dpmStatoContainerType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dpmStatoContainer"
})
@XmlRootElement(name = "dpmInvioXmlResponse")
public class DpmInvioXmlResponse {

    @XmlElement(required = true)
    protected DpmStatoContainerType dpmStatoContainer;

    /**
     * Recupera il valore della proprietà dpmStatoContainer.
     * 
     * @return
     *     possible object is
     *     {@link DpmStatoContainerType }
     *     
     */
    public DpmStatoContainerType getDpmStatoContainer() {
        return dpmStatoContainer;
    }

    /**
     * Imposta il valore della proprietà dpmStatoContainer.
     * 
     * @param value
     *     allowed object is
     *     {@link DpmStatoContainerType }
     *     
     */
    public void setDpmStatoContainer(DpmStatoContainerType value) {
        this.dpmStatoContainer = value;
    }

}
