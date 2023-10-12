//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per dpmStatoContainerType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dpmStatoContainerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="numeroAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *           &lt;element name="identificativoDatSoggettoAlimentante" type="{http://be.dpm.mds.it}identificativoSoggettoAlimentanteType"/&gt;
 *           &lt;element name="tipoEsito" type="{http://be.dpm.mds.it}esitoType"/&gt;
 *           &lt;element name="dataEmissioneRicevuta" type="{http://be.dpm.mds.it}calendarType" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dpmStatoContainerType", propOrder = {
    "numeroAtto",
    "identificativoDatSoggettoAlimentante",
    "tipoEsito",
    "dataEmissioneRicevuta"
})
public class DpmStatoContainerType {

    @XmlElementRef(name = "numeroAtto", namespace = "http://be.dpm.mds.it", type = JAXBElement.class, required = false)
    protected JAXBElement<String> numeroAtto;
    @XmlElement(required = true)
    protected String identificativoDatSoggettoAlimentante;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EsitoType tipoEsito;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataEmissioneRicevuta;

    /**
     * Recupera il valore della proprietà numeroAtto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNumeroAtto() {
        return numeroAtto;
    }

    /**
     * Imposta il valore della proprietà numeroAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNumeroAtto(JAXBElement<String> value) {
        this.numeroAtto = value;
    }

    /**
     * Recupera il valore della proprietà identificativoDatSoggettoAlimentante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoDatSoggettoAlimentante() {
        return identificativoDatSoggettoAlimentante;
    }

    /**
     * Imposta il valore della proprietà identificativoDatSoggettoAlimentante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoDatSoggettoAlimentante(String value) {
        this.identificativoDatSoggettoAlimentante = value;
    }

    /**
     * Recupera il valore della proprietà tipoEsito.
     * 
     * @return
     *     possible object is
     *     {@link EsitoType }
     *     
     */
    public EsitoType getTipoEsito() {
        return tipoEsito;
    }

    /**
     * Imposta il valore della proprietà tipoEsito.
     * 
     * @param value
     *     allowed object is
     *     {@link EsitoType }
     *     
     */
    public void setTipoEsito(EsitoType value) {
        this.tipoEsito = value;
    }

    /**
     * Recupera il valore della proprietà dataEmissioneRicevuta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataEmissioneRicevuta() {
        return dataEmissioneRicevuta;
    }

    /**
     * Imposta il valore della proprietà dataEmissioneRicevuta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataEmissioneRicevuta(XMLGregorianCalendar value) {
        this.dataEmissioneRicevuta = value;
    }

}
