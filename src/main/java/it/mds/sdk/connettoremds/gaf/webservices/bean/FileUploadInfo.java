/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per FileUploadInfo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="FileUploadInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nomeFlusso" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "FileUploadInfo", propOrder = {
    "nomeFlusso",
    "nomeFile"
})
public class FileUploadInfo {

    @XmlElement(required = true, nillable = true)
    protected String nomeFlusso;
    @XmlElement(required = true, nillable = true)
    protected String nomeFile;

    /**
     * Recupera il valore della proprietà nomeFlusso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeFlusso() {
        return nomeFlusso;
    }

    /**
     * Imposta il valore della proprietà nomeFlusso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeFlusso(String value) {
        this.nomeFlusso = value;
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
