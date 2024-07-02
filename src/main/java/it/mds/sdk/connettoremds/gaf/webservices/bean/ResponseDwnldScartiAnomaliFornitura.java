/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ResponseDwnldScartiAnomaliFornitura complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ResponseDwnldScartiAnomaliFornitura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="elencoScartiAnomali" type="{http://webservices.gaf.mds.com}ArrayOfFornituraRichiestaScartiAnomaliOut"/&gt;
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idFornitura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseDwnldScartiAnomaliFornitura", propOrder = {
    "elencoScartiAnomali",
    "errorCode",
    "errorText",
    "idFornitura"
})
public class ResponseDwnldScartiAnomaliFornitura {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfFornituraRichiestaScartiAnomaliOut elencoScartiAnomali;
    @XmlElement(required = true, nillable = true)
    protected String errorCode;
    @XmlElement(required = true, nillable = true)
    protected String errorText;
    @XmlElement(required = true, nillable = true)
    protected String idFornitura;

    /**
     * Recupera il valore della proprietà elencoScartiAnomali.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFornituraRichiestaScartiAnomaliOut }
     *     
     */
    public ArrayOfFornituraRichiestaScartiAnomaliOut getElencoScartiAnomali() {
        return elencoScartiAnomali;
    }

    /**
     * Imposta il valore della proprietà elencoScartiAnomali.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFornituraRichiestaScartiAnomaliOut }
     *     
     */
    public void setElencoScartiAnomali(ArrayOfFornituraRichiestaScartiAnomaliOut value) {
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

    /**
     * Recupera il valore della proprietà idFornitura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFornitura() {
        return idFornitura;
    }

    /**
     * Imposta il valore della proprietà idFornitura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFornitura(String value) {
        this.idFornitura = value;
    }

}
