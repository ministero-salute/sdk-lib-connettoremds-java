
package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java per UploadMonitoraggioIn complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="UploadMonitoraggioIn"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identificativiUpload" type="{http://webservices.gaf.mds.com}ArrayOf_xsd_string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadMonitoraggioIn", propOrder = {
    "identificativiUpload"
})
@XmlRootElement(name="listaUploadXML")
public class UploadMonitoraggioIn {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfXsdString identificativiUpload;

    /**
     * Recupera il valore della proprietà identificativiUpload.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfXsdString }
     *     
     */
    public ArrayOfXsdString getIdentificativiUpload() {
        return identificativiUpload;
    }

    /**
     * Imposta il valore della proprietà identificativiUpload.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfXsdString }
     *     
     */
    public void setIdentificativiUpload(ArrayOfXsdString value) {
        this.identificativiUpload = value;
    }

}
