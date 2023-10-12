
package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java per UploadRichiestaScartiAnomaliIn complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="UploadRichiestaScartiAnomaliIn"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="elencoUploadRichiesta" type="{http://webservices.gaf.mds.com}ArrayOfUploadScartiAnomaliElencoIn"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadRichiestaScartiAnomaliIn", propOrder = {
    "elencoUploadRichiesta"
})
@XmlRootElement(name="richiestaScrtAnmlIn")
public class UploadRichiestaScartiAnomaliIn {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfUploadScartiAnomaliElencoIn elencoUploadRichiesta;

    /**
     * Recupera il valore della proprietà elencoUploadRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUploadScartiAnomaliElencoIn }
     *     
     */
    public ArrayOfUploadScartiAnomaliElencoIn getElencoUploadRichiesta() {
        return elencoUploadRichiesta;
    }

    /**
     * Imposta il valore della proprietà elencoUploadRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUploadScartiAnomaliElencoIn }
     *     
     */
    public void setElencoUploadRichiesta(ArrayOfUploadScartiAnomaliElencoIn value) {
        this.elencoUploadRichiesta = value;
    }

}
