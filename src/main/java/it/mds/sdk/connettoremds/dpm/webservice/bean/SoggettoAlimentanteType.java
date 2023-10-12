//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per soggettoAlimentanteType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="soggettoAlimentanteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="regioneSoggettoAlimentante" type="{http://be.dpm.mds.it}codiceRegioneType"/&gt;
 *         &lt;element name="cap" type="{http://be.dpm.mds.it}capResidenzaType"/&gt;
 *         &lt;element name="codiceSoggettoAlimentante" type="{http://be.dpm.mds.it}codiceStrutturaType"/&gt;
 *         &lt;element name="indirizzo" type="{http://be.dpm.mds.it}indirizzoResidenzaType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soggettoAlimentanteType", propOrder = {
    "regioneSoggettoAlimentante",
    "cap",
    "codiceSoggettoAlimentante",
    "indirizzo"
})
public class SoggettoAlimentanteType {

    @XmlElement(required = true)
    protected String regioneSoggettoAlimentante;
    @XmlElement(required = true)
    protected String cap;
    @XmlElement(required = true)
    protected String codiceSoggettoAlimentante;
    @XmlElement(required = true)
    protected String indirizzo;

    /**
     * Recupera il valore della proprietà regioneSoggettoAlimentante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegioneSoggettoAlimentante() {
        return regioneSoggettoAlimentante;
    }

    /**
     * Imposta il valore della proprietà regioneSoggettoAlimentante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegioneSoggettoAlimentante(String value) {
        this.regioneSoggettoAlimentante = value;
    }

    /**
     * Recupera il valore della proprietà cap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCap() {
        return cap;
    }

    /**
     * Imposta il valore della proprietà cap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCap(String value) {
        this.cap = value;
    }

    /**
     * Recupera il valore della proprietà codiceSoggettoAlimentante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceSoggettoAlimentante() {
        return codiceSoggettoAlimentante;
    }

    /**
     * Imposta il valore della proprietà codiceSoggettoAlimentante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceSoggettoAlimentante(String value) {
        this.codiceSoggettoAlimentante = value;
    }

    /**
     * Recupera il valore della proprietà indirizzo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Imposta il valore della proprietà indirizzo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzo(String value) {
        this.indirizzo = value;
    }

}
