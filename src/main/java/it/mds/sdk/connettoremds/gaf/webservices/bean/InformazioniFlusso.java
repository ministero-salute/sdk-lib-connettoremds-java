
package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java per InformazioniFlusso complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="InformazioniFlusso"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categoriaFlussi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fileUpload" type="{http://webservices.gaf.mds.com}ArrayOfFileUploadInfo"/&gt;
 *         &lt;element name="periodoRiferimento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="annoRiferimento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformazioniFlusso", propOrder = {
    "categoriaFlussi",
    "fileUpload",
    "periodoRiferimento",
    "annoRiferimento"
})
@XmlRootElement(name="informazioniFlusso")
public class InformazioniFlusso {

    @XmlElement(required = true, nillable = true)
    protected String categoriaFlussi;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfFileUploadInfo fileUpload;
    @XmlElement(required = true, nillable = true)
    protected String periodoRiferimento;
    @XmlElement(required = true, nillable = true)
    protected String annoRiferimento;

    /**
     * Recupera il valore della proprietà categoriaFlussi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoriaFlussi() {
        return categoriaFlussi;
    }

    /**
     * Imposta il valore della proprietà categoriaFlussi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoriaFlussi(String value) {
        this.categoriaFlussi = value;
    }

    /**
     * Recupera il valore della proprietà fileUpload.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFileUploadInfo }
     *     
     */
    public ArrayOfFileUploadInfo getFileUpload() {
        return fileUpload;
    }

    /**
     * Imposta il valore della proprietà fileUpload.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFileUploadInfo }
     *     
     */
    public void setFileUpload(ArrayOfFileUploadInfo value) {
        this.fileUpload = value;
    }

    /**
     * Recupera il valore della proprietà periodoRiferimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodoRiferimento() {
        return periodoRiferimento;
    }

    /**
     * Imposta il valore della proprietà periodoRiferimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodoRiferimento(String value) {
        this.periodoRiferimento = value;
    }

    /**
     * Recupera il valore della proprietà annoRiferimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoRiferimento() {
        return annoRiferimento;
    }

    /**
     * Imposta il valore della proprietà annoRiferimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoRiferimento(String value) {
        this.annoRiferimento = value;
    }

}
