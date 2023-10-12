//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="donatore" type="{http://be.dpm.mds.it}anagrafePersonaType" minOccurs="0"/&gt;
 *         &lt;element name="disponenti" type="{http://be.dpm.mds.it}anagrafePersonaType" maxOccurs="2"/&gt;
 *         &lt;element name="fiduciari" type="{http://be.dpm.mds.it}anagrafePersonaType" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element name="soggettoAlimentante" type="{http://be.dpm.mds.it}soggettoAlimentanteType"/&gt;
 *         &lt;element name="identificativoSoggettoAlimentante" type="{http://be.dpm.mds.it}identificativoSoggettoAlimentanteType"/&gt;
 *         &lt;element name="dataSottoscrizione" type="{http://be.dpm.mds.it}calendarType"/&gt;
 *         &lt;element name="tipoAtto" type="{http://be.dpm.mds.it}tipoAttoType"/&gt;
 *         &lt;element name="formatoAtto" type="{http://be.dpm.mds.it}formatoAttoType"/&gt;
 *         &lt;element name="tipoDisponente" type="{http://be.dpm.mds.it}tipoDisponenteType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="donatoreMinorenne" use="required" type="{http://be.dpm.mds.it}yesNoType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "donatore",
    "disponenti",
    "fiduciari",
    "soggettoAlimentante",
    "identificativoSoggettoAlimentante",
    "dataSottoscrizione",
    "tipoAtto",
    "formatoAtto",
    "tipoDisponente"
})
@XmlRootElement(name = "dpm")
public class Dpm {

    protected AnagrafePersonaType donatore;
    @XmlElement(required = true)
    protected List<AnagrafePersonaType> disponenti;
    protected List<AnagrafePersonaType> fiduciari;
    @XmlElement(required = true)
    protected SoggettoAlimentanteType soggettoAlimentante;
    @XmlElement(required = true)
    protected String identificativoSoggettoAlimentante;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataSottoscrizione;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoAttoType tipoAtto;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected FormatoAttoType formatoAtto;
    @XmlSchemaType(name = "string")
    protected TipoDisponenteType tipoDisponente;
    @XmlAttribute(name = "donatoreMinorenne", required = true)
    protected YesNoType donatoreMinorenne;

    /**
     * Recupera il valore della proprietà donatore.
     * 
     * @return
     *     possible object is
     *     {@link AnagrafePersonaType }
     *     
     */
    public AnagrafePersonaType getDonatore() {
        return donatore;
    }

    /**
     * Imposta il valore della proprietà donatore.
     * 
     * @param value
     *     allowed object is
     *     {@link AnagrafePersonaType }
     *     
     */
    public void setDonatore(AnagrafePersonaType value) {
        this.donatore = value;
    }

    /**
     * Gets the value of the disponenti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the disponenti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisponenti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnagrafePersonaType }
     * 
     * 
     */
    public List<AnagrafePersonaType> getDisponenti() {
        if (disponenti == null) {
            disponenti = new ArrayList<AnagrafePersonaType>();
        }
        return this.disponenti;
    }

    /**
     * Gets the value of the fiduciari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the fiduciari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFiduciari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnagrafePersonaType }
     * 
     * 
     */
    public List<AnagrafePersonaType> getFiduciari() {
        if (fiduciari == null) {
            fiduciari = new ArrayList<AnagrafePersonaType>();
        }
        return this.fiduciari;
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
     * Recupera il valore della proprietà dataSottoscrizione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataSottoscrizione() {
        return dataSottoscrizione;
    }

    /**
     * Imposta il valore della proprietà dataSottoscrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataSottoscrizione(XMLGregorianCalendar value) {
        this.dataSottoscrizione = value;
    }

    /**
     * Recupera il valore della proprietà tipoAtto.
     * 
     * @return
     *     possible object is
     *     {@link TipoAttoType }
     *     
     */
    public TipoAttoType getTipoAtto() {
        return tipoAtto;
    }

    /**
     * Imposta il valore della proprietà tipoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoAttoType }
     *     
     */
    public void setTipoAtto(TipoAttoType value) {
        this.tipoAtto = value;
    }

    /**
     * Recupera il valore della proprietà formatoAtto.
     * 
     * @return
     *     possible object is
     *     {@link FormatoAttoType }
     *     
     */
    public FormatoAttoType getFormatoAtto() {
        return formatoAtto;
    }

    /**
     * Imposta il valore della proprietà formatoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link FormatoAttoType }
     *     
     */
    public void setFormatoAtto(FormatoAttoType value) {
        this.formatoAtto = value;
    }

    /**
     * Recupera il valore della proprietà tipoDisponente.
     * 
     * @return
     *     possible object is
     *     {@link TipoDisponenteType }
     *     
     */
    public TipoDisponenteType getTipoDisponente() {
        return tipoDisponente;
    }

    /**
     * Imposta il valore della proprietà tipoDisponente.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoDisponenteType }
     *     
     */
    public void setTipoDisponente(TipoDisponenteType value) {
        this.tipoDisponente = value;
    }

    /**
     * Recupera il valore della proprietà donatoreMinorenne.
     * 
     * @return
     *     possible object is
     *     {@link YesNoType }
     *     
     */
    public YesNoType getDonatoreMinorenne() {
        return donatoreMinorenne;
    }

    /**
     * Imposta il valore della proprietà donatoreMinorenne.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoType }
     *     
     */
    public void setDonatoreMinorenne(YesNoType value) {
        this.donatoreMinorenne = value;
    }

}
