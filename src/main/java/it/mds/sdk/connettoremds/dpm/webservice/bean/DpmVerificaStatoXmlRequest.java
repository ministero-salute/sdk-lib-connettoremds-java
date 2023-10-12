//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


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
 *         &lt;element name="dpmVerificaStatoMetaDati" type="{http://be.dpm.mds.it}dpmVerificaStatoType"/&gt;
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
    "dpmVerificaStatoMetaDati"
})
@XmlRootElement(name = "dpmVerificaStatoXmlRequest")
public class DpmVerificaStatoXmlRequest {

    @XmlElement(required = true)
    protected DpmVerificaStatoType dpmVerificaStatoMetaDati;

    /**
     * Recupera il valore della proprietà dpmVerificaStatoMetaDati.
     * 
     * @return
     *     possible object is
     *     {@link DpmVerificaStatoType }
     *     
     */
    public DpmVerificaStatoType getDpmVerificaStatoMetaDati() {
        return dpmVerificaStatoMetaDati;
    }

    /**
     * Imposta il valore della proprietà dpmVerificaStatoMetaDati.
     * 
     * @param value
     *     allowed object is
     *     {@link DpmVerificaStatoType }
     *     
     */
    public void setDpmVerificaStatoMetaDati(DpmVerificaStatoType value) {
        this.dpmVerificaStatoMetaDati = value;
    }

}
