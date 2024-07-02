/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.dispovig.webservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per uploadFile complex type.
 *
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 *
 * <pre>
 * &lt;complexType name="uploadFile"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nomeFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadFile", propOrder = {
        "nomeFile",
        "file"
})
public class UploadFile {

    protected String nomeFile;
    @XmlElementRef(name = "file", type = JAXBElement.class, required = false)
    protected byte[] file;

    /**
     * Recupera il valore della propriet� nomeFile.
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
     * Imposta il valore della propriet� nomeFile.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNomeFile(String value) {
        this.nomeFile = value;
    }

    /**
     * Recupera il valore della propriet� file.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * Imposta il valore della propriet� file.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *
     */
    public void setFile(byte[] value) {
        this.file = value;
    }

}
