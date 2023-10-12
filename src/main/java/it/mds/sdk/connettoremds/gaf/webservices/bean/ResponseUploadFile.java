
package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java per ResponseUploadFile complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ResponseUploadFile"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceFornitura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="listaEsitiUpload" type="{http://webservices.gaf.mds.com}ArrayOfUploadEsito"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseUploadFile", propOrder = {
    "codiceFornitura",
    "errorCode",
    "errorText",
    "listaEsitiUpload"
})
@XmlRootElement(name="invioFlussiReturn")
public class ResponseUploadFile {

    @XmlElement(required = true, nillable = true)
    protected String codiceFornitura;
    @XmlElement(required = true, nillable = true)
    protected String errorCode;
    @XmlElement(required = true, nillable = true)
    protected String errorText;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfUploadEsito listaEsitiUpload;

    /**
     * Recupera il valore della proprietà codiceFornitura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFornitura() {
        return codiceFornitura;
    }

    /**
     * Imposta il valore della proprietà codiceFornitura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFornitura(String value) {
        this.codiceFornitura = value;
    }

    /**
     * Recupera il valore della proprietà errorCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Imposta il valore della proprietà errorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Recupera il valore della proprietà errorText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorText() {
        return errorText;
    }

    /**
     * Imposta il valore della proprietà errorText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorText(String value) {
        this.errorText = value;
    }

    /**
     * Recupera il valore della proprietà listaEsitiUpload.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUploadEsito }
     *     
     */
    public ArrayOfUploadEsito getListaEsitiUpload() {
        return listaEsitiUpload;
    }

    /**
     * Imposta il valore della proprietà listaEsitiUpload.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUploadEsito }
     *     
     */
    public void setListaEsitiUpload(ArrayOfUploadEsito value) {
        this.listaEsitiUpload = value;
    }

}
