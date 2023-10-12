//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per anagrafePersonaType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="anagrafePersonaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="luogoNascita" type="{http://be.dpm.mds.it}anagrafeGeoType"/&gt;
 *         &lt;element name="luogoResidenza" type="{http://be.dpm.mds.it}anagrafeGeoType"/&gt;
 *         &lt;element name="nome" type="{http://be.dpm.mds.it}cognomeNometype"/&gt;
 *         &lt;element name="cognome" type="{http://be.dpm.mds.it}cognomeNometype"/&gt;
 *         &lt;element name="codiceFiscale" type="{http://be.dpm.mds.it}codiceFiscaleType"/&gt;
 *         &lt;element name="dataNascita" type="{http://be.dpm.mds.it}calendarType"/&gt;
 *         &lt;element name="indirizzoResidenza" type="{http://be.dpm.mds.it}indirizzoResidenzaType"/&gt;
 *         &lt;element name="capResidenza" type="{http://be.dpm.mds.it}capResidenzaType"/&gt;
 *         &lt;element name="email" type="{http://be.dpm.mds.it}emailType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="consensoEmail" type="{http://be.dpm.mds.it}yesNoType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anagrafePersonaType", propOrder = {
    "luogoNascita",
    "luogoResidenza",
    "nome",
    "cognome",
    "codiceFiscale",
    "dataNascita",
    "indirizzoResidenza",
    "capResidenza",
    "email"
})
public class AnagrafePersonaType {

    @XmlElement(required = true)
    protected AnagrafeGeoType luogoNascita;
    @XmlElement(required = true)
    protected AnagrafeGeoType luogoResidenza;
    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected String cognome;
    @XmlElement(required = true)
    protected String codiceFiscale;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataNascita;
    @XmlElement(required = true)
    protected String indirizzoResidenza;
    @XmlElement(required = true)
    protected String capResidenza;
    protected String email;
    @XmlAttribute(name = "consensoEmail")
    protected YesNoType consensoEmail;

    /**
     * Recupera il valore della proprietà luogoNascita.
     * 
     * @return
     *     possible object is
     *     {@link AnagrafeGeoType }
     *     
     */
    public AnagrafeGeoType getLuogoNascita() {
        return luogoNascita;
    }

    /**
     * Imposta il valore della proprietà luogoNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link AnagrafeGeoType }
     *     
     */
    public void setLuogoNascita(AnagrafeGeoType value) {
        this.luogoNascita = value;
    }

    /**
     * Recupera il valore della proprietà luogoResidenza.
     * 
     * @return
     *     possible object is
     *     {@link AnagrafeGeoType }
     *     
     */
    public AnagrafeGeoType getLuogoResidenza() {
        return luogoResidenza;
    }

    /**
     * Imposta il valore della proprietà luogoResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link AnagrafeGeoType }
     *     
     */
    public void setLuogoResidenza(AnagrafeGeoType value) {
        this.luogoResidenza = value;
    }

    /**
     * Recupera il valore della proprietà nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il valore della proprietà nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Recupera il valore della proprietà cognome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il valore della proprietà cognome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognome(String value) {
        this.cognome = value;
    }

    /**
     * Recupera il valore della proprietà codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della proprietà codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Recupera il valore della proprietà dataNascita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataNascita() {
        return dataNascita;
    }

    /**
     * Imposta il valore della proprietà dataNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataNascita(XMLGregorianCalendar value) {
        this.dataNascita = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoResidenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    /**
     * Imposta il valore della proprietà indirizzoResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzoResidenza(String value) {
        this.indirizzoResidenza = value;
    }

    /**
     * Recupera il valore della proprietà capResidenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapResidenza() {
        return capResidenza;
    }

    /**
     * Imposta il valore della proprietà capResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapResidenza(String value) {
        this.capResidenza = value;
    }

    /**
     * Recupera il valore della proprietà email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta il valore della proprietà email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Recupera il valore della proprietà consensoEmail.
     * 
     * @return
     *     possible object is
     *     {@link YesNoType }
     *     
     */
    public YesNoType getConsensoEmail() {
        return consensoEmail;
    }

    /**
     * Imposta il valore della proprietà consensoEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoType }
     *     
     */
    public void setConsensoEmail(YesNoType value) {
        this.consensoEmail = value;
    }

}
