
package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per UploadScartiAnomaliElencoIn complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="UploadScartiAnomaliElencoIn"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idUpload" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoFile" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadScartiAnomaliElencoIn", propOrder = {
    "idUpload",
    "tipoFile"
})
public class UploadScartiAnomaliElencoIn {

    @XmlElement(required = true, nillable = true)
    protected String idUpload;
    @XmlElement(required = true, nillable = true)
    protected String tipoFile;

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
     * Recupera il valore della proprietà tipoFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoFile() {
        return tipoFile;
    }

    /**
     * Imposta il valore della proprietà tipoFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoFile(String value) {
        this.tipoFile = value;
    }

}
