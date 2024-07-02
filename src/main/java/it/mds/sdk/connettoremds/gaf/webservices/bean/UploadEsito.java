/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per UploadEsito complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="UploadEsito"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idUpload" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="esito" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nomeFile" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadEsito", propOrder = {
    "idUpload",
    "esito",
    "nomeFile"
})
public class UploadEsito {

    @XmlElement(required = true, nillable = true)
    protected String idUpload;
    @XmlElement(required = true, nillable = true)
    protected String esito;
    @XmlElement(required = true, nillable = true)
    protected String nomeFile;

    /**
     * Recupera il valore della proprietà idUpload.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUpload() {
        return idUpload;
    }

    /**
     * Imposta il valore della proprietà idUpload.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUpload(String value) {
        this.idUpload = value;
    }

    /**
     * Recupera il valore della proprietà esito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsito(String value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della proprietà nomeFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeFile() {
        return nomeFile;
    }

    /**
     * Imposta il valore della proprietà nomeFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeFile(String value) {
        this.nomeFile = value;
    }

}
