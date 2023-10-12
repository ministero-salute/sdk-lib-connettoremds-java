
package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ResponseUploadMonitoraggio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ResponseUploadMonitoraggio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="uploadMonitoraggio" type="{http://webservices.gaf.mds.com}ArrayOfUploadMonitoraggioOut"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseUploadMonitoraggio", propOrder = {
    "errorCode",
    "errorText",
    "uploadMonitoraggio"
})
public class ResponseUploadMonitoraggio {

    @XmlElement(required = true, nillable = true)
    protected String errorCode;
    @XmlElement(required = true, nillable = true)
    protected String errorText;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfUploadMonitoraggioOut uploadMonitoraggio;

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
     * Recupera il valore della proprietà uploadMonitoraggio.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUploadMonitoraggioOut }
     *     
     */
    public ArrayOfUploadMonitoraggioOut getUploadMonitoraggio() {
        return uploadMonitoraggio;
    }

    /**
     * Imposta il valore della proprietà uploadMonitoraggio.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUploadMonitoraggioOut }
     *     
     */
    public void setUploadMonitoraggio(ArrayOfUploadMonitoraggioOut value) {
        this.uploadMonitoraggio = value;
    }

}
