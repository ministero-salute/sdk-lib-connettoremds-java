//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java per dpmInvioType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dpmInvioType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identificativoDatSoggettoAlimentante" type="{http://be.dpm.mds.it}identificativoSoggettoAlimentanteType"/&gt;
 *         &lt;element name="soggettoAlimentante" type="{http://be.dpm.mds.it}soggettoAlimentanteType"/&gt;
 *         &lt;element name="tipoAtto" type="{http://be.dpm.mds.it}tipoAttoType"/&gt;
 *         &lt;element name="allegati" type="{http://be.dpm.mds.it}allegatiType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dpmInvioType", propOrder = {
    "identificativoDatSoggettoAlimentante",
    "soggettoAlimentante",
    "tipoAtto",
    "allegati"
})
public class DpmInvioType {

    @XmlElement(required = true)
    protected String identificativoDatSoggettoAlimentante;
    @XmlElement(required = true)
    protected SoggettoAlimentanteType soggettoAlimentante;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoAttoType tipoAtto;
    @XmlElement(required = true)
    protected AllegatiType allegati;

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
     * Recupera il valore della proprietà allegati.
     * 
     * @return
     *     possible object is
     *     {@link AllegatiType }
     *     
     */
    public AllegatiType getAllegati() {
        return allegati;
    }

    /**
     * Imposta il valore della proprietà allegati.
     * 
     * @param value
     *     allowed object is
     *     {@link AllegatiType }
     *     
     */
    public void setAllegati(AllegatiType value) {
        this.allegati = value;
    }

}
