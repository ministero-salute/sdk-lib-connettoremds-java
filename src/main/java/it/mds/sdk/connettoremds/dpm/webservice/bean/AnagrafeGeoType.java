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
 * <p>Classe Java per anagrafeGeoType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="anagrafeGeoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceNazione" type="{http://be.dpm.mds.it}codiceNazioneType"/&gt;
 *         &lt;element name="codiceRegione" type="{http://be.dpm.mds.it}codiceRegioneType"/&gt;
 *         &lt;element name="codiceProvincia" type="{http://be.dpm.mds.it}codiceProvinciaType"/&gt;
 *         &lt;element name="codiceComune" type="{http://be.dpm.mds.it}codiceComuneType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anagrafeGeoType", propOrder = {
    "codiceNazione",
    "codiceRegione",
    "codiceProvincia",
    "codiceComune"
})
public class AnagrafeGeoType {

    @XmlElement(required = true)
    protected String codiceNazione;
    @XmlElement(required = true)
    protected String codiceRegione;
    @XmlElement(required = true)
    protected String codiceProvincia;
    @XmlElement(required = true)
    protected String codiceComune;

    /**
     * Recupera il valore della proprietà codiceNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceNazione() {
        return codiceNazione;
    }

    /**
     * Imposta il valore della proprietà codiceNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceNazione(String value) {
        this.codiceNazione = value;
    }

    /**
     * Recupera il valore della proprietà codiceRegione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceRegione() {
        return codiceRegione;
    }

    /**
     * Imposta il valore della proprietà codiceRegione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceRegione(String value) {
        this.codiceRegione = value;
    }

    /**
     * Recupera il valore della proprietà codiceProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceProvincia() {
        return codiceProvincia;
    }

    /**
     * Imposta il valore della proprietà codiceProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceProvincia(String value) {
        this.codiceProvincia = value;
    }

    /**
     * Recupera il valore della proprietà codiceComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceComune() {
        return codiceComune;
    }

    /**
     * Imposta il valore della proprietà codiceComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceComune(String value) {
        this.codiceComune = value;
    }

}
