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
 *         &lt;element name="numeroAtto" type="{http://be.dpm.mds.it}numeroAttoType" minOccurs="0"/&gt;
 *         &lt;element name="identificativoSoggettoAlimentante" type="{http://be.dpm.mds.it}identificativoSoggettoAlimentanteType"/&gt;
 *         &lt;element name="tipoEsito" type="{http://be.dpm.mds.it}esitoType"/&gt;
 *         &lt;element name="dettagli" type="{http://be.dpm.mds.it}dettaglioType" minOccurs="0"/&gt;
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
    "numeroAtto",
    "identificativoSoggettoAlimentante",
    "tipoEsito",
    "dettagli"
})
@XmlRootElement(name = "dpmOut")
public class DpmOut {

    protected String numeroAtto;
    @XmlElement(required = true)
    protected String identificativoSoggettoAlimentante;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EsitoType tipoEsito;
    protected DettaglioType dettagli;

    /**
     * Recupera il valore della proprietà numeroAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroAtto() {
        return numeroAtto;
    }

    /**
     * Imposta il valore della proprietà numeroAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroAtto(String value) {
        this.numeroAtto = value;
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
     * Recupera il valore della proprietà dettagli.
     * 
     * @return
     *     possible object is
     *     {@link DettaglioType }
     *     
     */
    public DettaglioType getDettagli() {
        return dettagli;
    }

    /**
     * Imposta il valore della proprietà dettagli.
     * 
     * @param value
     *     allowed object is
     *     {@link DettaglioType }
     *     
     */
    public void setDettagli(DettaglioType value) {
        this.dettagli = value;
    }

}
