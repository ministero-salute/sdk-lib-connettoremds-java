
package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java per ResponseDwnldScartiAnomaliUpload complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ResponseDwnldScartiAnomaliUpload"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="elencoScartiAnomali" type="{http://webservices.gaf.mds.com}ArrayOfUploadRichiestaScartiAnomaliOut"/&gt;
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseDwnldScartiAnomaliUpload", propOrder = {
    "elencoScartiAnomali",
    "errorCode",
    "errorText"
})
@XmlRootElement(name ="dwnldAnmSctUploadReturn")
public class ResponseDwnldScartiAnomaliUpload {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfUploadRichiestaScartiAnomaliOut elencoScartiAnomali;
    @XmlElement(required = true, nillable = true)
    protected String errorCode;
    @XmlElement(required = true, nillable = true)
    protected String errorText;

    /**
     * Recupera il valore della proprietà elencoScartiAnomali.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUploadRichiestaScartiAnomaliOut }
     *     
     */
    public ArrayOfUploadRichiestaScartiAnomaliOut getElencoScartiAnomali() {
        return elencoScartiAnomali;
    }

    /**
     * Imposta il valore della proprietà elencoScartiAnomali.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUploadRichiestaScartiAnomaliOut }
     *     
     */
    public void setElencoScartiAnomali(ArrayOfUploadRichiestaScartiAnomaliOut value) {
        this.elencoScartiAnomali = value;
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

}
