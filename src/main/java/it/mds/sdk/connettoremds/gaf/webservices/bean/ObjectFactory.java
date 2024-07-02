/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.gaf.webservices.bean;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mds.gaf.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InformazioniFlusso_QNAME = new QName("http://webservices.gaf.mds.com", "informazioniFlusso");
    private final static QName _InvioFlussiReturn_QNAME = new QName("http://webservices.gaf.mds.com", "invioFlussiReturn");
    private final static QName _ListaUpload_QNAME = new QName("http://webservices.gaf.mds.com", "listaUpload");
    private final static QName _MonEsiUploadReturn_QNAME = new QName("http://webservices.gaf.mds.com", "monEsiUploadReturn");
    private final static QName _IdentificativoFornitura_QNAME = new QName("http://webservices.gaf.mds.com", "identificativoFornitura");
    private final static QName _MonEsiFornituraReturn_QNAME = new QName("http://webservices.gaf.mds.com", "monEsiFornituraReturn");
    private final static QName _ListaUploadXML_QNAME = new QName("http://webservices.gaf.mds.com", "listaUploadXML");
    private final static QName _MonEsiUploadXMLReturn_QNAME = new QName("http://webservices.gaf.mds.com", "monEsiUploadXMLReturn");
    private final static QName _IdentificativoFornituraXML_QNAME = new QName("http://webservices.gaf.mds.com", "identificativoFornituraXML");
    private final static QName _MonEsiFornituraXMLReturn_QNAME = new QName("http://webservices.gaf.mds.com", "monEsiFornituraXMLReturn");
    private final static QName _RichiestaScrtAnmlIn_QNAME = new QName("http://webservices.gaf.mds.com", "richiestaScrtAnmlIn");
    private final static QName _DwnldAnmSctUploadReturn_QNAME = new QName("http://webservices.gaf.mds.com", "dwnldAnmSctUploadReturn");
    private final static QName _RichiestaScrtAnmlFrnIn_QNAME = new QName("http://webservices.gaf.mds.com", "richiestaScrtAnmlFrnIn");
    private final static QName _DwnldAnmSctFornituraReturn_QNAME = new QName("http://webservices.gaf.mds.com", "dwnldAnmSctFornituraReturn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mds.gaf.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InformazioniFlusso }
     * 
     */
    public InformazioniFlusso createInformazioniFlusso() {
        return new InformazioniFlusso();
    }

    /**
     * Create an instance of {@link ResponseUploadFile }
     * 
     */
    public ResponseUploadFile createResponseUploadFile() {
        return new ResponseUploadFile();
    }

    /**
     * Create an instance of {@link UploadMonitoraggioIn }
     * 
     */
    public UploadMonitoraggioIn createUploadMonitoraggioIn() {
        return new UploadMonitoraggioIn();
    }

    /**
     * Create an instance of {@link ResponseUploadMonitoraggio }
     * 
     */
    public ResponseUploadMonitoraggio createResponseUploadMonitoraggio() {
        return new ResponseUploadMonitoraggio();
    }

    /**
     * Create an instance of {@link ResponseFornituraMonitoraggio }
     * 
     */
    public ResponseFornituraMonitoraggio createResponseFornituraMonitoraggio() {
        return new ResponseFornituraMonitoraggio();
    }

    /**
     * Create an instance of {@link ResponseUploadXML }
     * 
     */
    public ResponseUploadXML createResponseUploadXML() {
        return new ResponseUploadXML();
    }

    /**
     * Create an instance of {@link ResponseFornituraXML }
     * 
     */
    public ResponseFornituraXML createResponseFornituraXML() {
        return new ResponseFornituraXML();
    }

    /**
     * Create an instance of {@link UploadRichiestaScartiAnomaliIn }
     * 
     */
    public UploadRichiestaScartiAnomaliIn createUploadRichiestaScartiAnomaliIn() {
        return new UploadRichiestaScartiAnomaliIn();
    }

    /**
     * Create an instance of {@link ResponseDwnldScartiAnomaliUpload }
     * 
     */
    public ResponseDwnldScartiAnomaliUpload createResponseDwnldScartiAnomaliUpload() {
        return new ResponseDwnldScartiAnomaliUpload();
    }

    /**
     * Create an instance of {@link FornituraRichiestaScartiAnomaliIn }
     * 
     */
    public FornituraRichiestaScartiAnomaliIn createFornituraRichiestaScartiAnomaliIn() {
        return new FornituraRichiestaScartiAnomaliIn();
    }

    /**
     * Create an instance of {@link ResponseDwnldScartiAnomaliFornitura }
     * 
     */
    public ResponseDwnldScartiAnomaliFornitura createResponseDwnldScartiAnomaliFornitura() {
        return new ResponseDwnldScartiAnomaliFornitura();
    }

    /**
     * Create an instance of {@link FileUploadInfo }
     * 
     */
    public FileUploadInfo createFileUploadInfo() {
        return new FileUploadInfo();
    }

    /**
     * Create an instance of {@link ArrayOfFileUploadInfo }
     * 
     */
    public ArrayOfFileUploadInfo createArrayOfFileUploadInfo() {
        return new ArrayOfFileUploadInfo();
    }

    /**
     * Create an instance of {@link UploadEsito }
     * 
     */
    public UploadEsito createUploadEsito() {
        return new UploadEsito();
    }

    /**
     * Create an instance of {@link ArrayOfUploadEsito }
     * 
     */
    public ArrayOfUploadEsito createArrayOfUploadEsito() {
        return new ArrayOfUploadEsito();
    }

    /**
     * Create an instance of {@link ArrayOfXsdString }
     * 
     */
    public ArrayOfXsdString createArrayOfXsdString() {
        return new ArrayOfXsdString();
    }

    /**
     * Create an instance of {@link UploadMonitoraggioOut }
     * 
     */
    public UploadMonitoraggioOut createUploadMonitoraggioOut() {
        return new UploadMonitoraggioOut();
    }

    /**
     * Create an instance of {@link ArrayOfUploadMonitoraggioOut }
     * 
     */
    public ArrayOfUploadMonitoraggioOut createArrayOfUploadMonitoraggioOut() {
        return new ArrayOfUploadMonitoraggioOut();
    }

    /**
     * Create an instance of {@link UploadFornituraOut }
     * 
     */
    public UploadFornituraOut createUploadFornituraOut() {
        return new UploadFornituraOut();
    }

    /**
     * Create an instance of {@link ArrayOfUploadFornituraOut }
     * 
     */
    public ArrayOfUploadFornituraOut createArrayOfUploadFornituraOut() {
        return new ArrayOfUploadFornituraOut();
    }

    /**
     * Create an instance of {@link UploadScartiAnomaliElencoIn }
     * 
     */
    public UploadScartiAnomaliElencoIn createUploadScartiAnomaliElencoIn() {
        return new UploadScartiAnomaliElencoIn();
    }

    /**
     * Create an instance of {@link ArrayOfUploadScartiAnomaliElencoIn }
     * 
     */
    public ArrayOfUploadScartiAnomaliElencoIn createArrayOfUploadScartiAnomaliElencoIn() {
        return new ArrayOfUploadScartiAnomaliElencoIn();
    }

    /**
     * Create an instance of {@link UploadRichiestaScartiAnomaliOut }
     * 
     */
    public UploadRichiestaScartiAnomaliOut createUploadRichiestaScartiAnomaliOut() {
        return new UploadRichiestaScartiAnomaliOut();
    }

    /**
     * Create an instance of {@link ArrayOfUploadRichiestaScartiAnomaliOut }
     * 
     */
    public ArrayOfUploadRichiestaScartiAnomaliOut createArrayOfUploadRichiestaScartiAnomaliOut() {
        return new ArrayOfUploadRichiestaScartiAnomaliOut();
    }

    /**
     * Create an instance of {@link FornituraRichiestaScartiAnomaliOut }
     * 
     */
    public FornituraRichiestaScartiAnomaliOut createFornituraRichiestaScartiAnomaliOut() {
        return new FornituraRichiestaScartiAnomaliOut();
    }

    /**
     * Create an instance of {@link ArrayOfFornituraRichiestaScartiAnomaliOut }
     * 
     */
    public ArrayOfFornituraRichiestaScartiAnomaliOut createArrayOfFornituraRichiestaScartiAnomaliOut() {
        return new ArrayOfFornituraRichiestaScartiAnomaliOut();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformazioniFlusso }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InformazioniFlusso }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "informazioniFlusso")
    public JAXBElement<InformazioniFlusso> createInformazioniFlusso(InformazioniFlusso value) {
        return new JAXBElement<InformazioniFlusso>(_InformazioniFlusso_QNAME, InformazioniFlusso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseUploadFile }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseUploadFile }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "invioFlussiReturn")
    public JAXBElement<ResponseUploadFile> createInvioFlussiReturn(ResponseUploadFile value) {
        return new JAXBElement<ResponseUploadFile>(_InvioFlussiReturn_QNAME, ResponseUploadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadMonitoraggioIn }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UploadMonitoraggioIn }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "listaUpload")
    public JAXBElement<UploadMonitoraggioIn> createListaUpload(UploadMonitoraggioIn value) {
        return new JAXBElement<UploadMonitoraggioIn>(_ListaUpload_QNAME, UploadMonitoraggioIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseUploadMonitoraggio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseUploadMonitoraggio }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "monEsiUploadReturn")
    public JAXBElement<ResponseUploadMonitoraggio> createMonEsiUploadReturn(ResponseUploadMonitoraggio value) {
        return new JAXBElement<ResponseUploadMonitoraggio>(_MonEsiUploadReturn_QNAME, ResponseUploadMonitoraggio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "identificativoFornitura")
    public JAXBElement<String> createIdentificativoFornitura(String value) {
        return new JAXBElement<String>(_IdentificativoFornitura_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseFornituraMonitoraggio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseFornituraMonitoraggio }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "monEsiFornituraReturn")
    public JAXBElement<ResponseFornituraMonitoraggio> createMonEsiFornituraReturn(ResponseFornituraMonitoraggio value) {
        return new JAXBElement<ResponseFornituraMonitoraggio>(_MonEsiFornituraReturn_QNAME, ResponseFornituraMonitoraggio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadMonitoraggioIn }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UploadMonitoraggioIn }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "listaUploadXML")
    public JAXBElement<UploadMonitoraggioIn> createListaUploadXML(UploadMonitoraggioIn value) {
        return new JAXBElement<UploadMonitoraggioIn>(_ListaUploadXML_QNAME, UploadMonitoraggioIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseUploadXML }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseUploadXML }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "monEsiUploadXMLReturn")
    public JAXBElement<ResponseUploadXML> createMonEsiUploadXMLReturn(ResponseUploadXML value) {
        return new JAXBElement<ResponseUploadXML>(_MonEsiUploadXMLReturn_QNAME, ResponseUploadXML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "identificativoFornituraXML")
    public JAXBElement<String> createIdentificativoFornituraXML(String value) {
        return new JAXBElement<String>(_IdentificativoFornituraXML_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseFornituraXML }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseFornituraXML }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "monEsiFornituraXMLReturn")
    public JAXBElement<ResponseFornituraXML> createMonEsiFornituraXMLReturn(ResponseFornituraXML value) {
        return new JAXBElement<ResponseFornituraXML>(_MonEsiFornituraXMLReturn_QNAME, ResponseFornituraXML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadRichiestaScartiAnomaliIn }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UploadRichiestaScartiAnomaliIn }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "richiestaScrtAnmlIn")
    public JAXBElement<UploadRichiestaScartiAnomaliIn> createRichiestaScrtAnmlIn(UploadRichiestaScartiAnomaliIn value) {
        return new JAXBElement<UploadRichiestaScartiAnomaliIn>(_RichiestaScrtAnmlIn_QNAME, UploadRichiestaScartiAnomaliIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseDwnldScartiAnomaliUpload }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseDwnldScartiAnomaliUpload }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "dwnldAnmSctUploadReturn")
    public JAXBElement<ResponseDwnldScartiAnomaliUpload> createDwnldAnmSctUploadReturn(ResponseDwnldScartiAnomaliUpload value) {
        return new JAXBElement<ResponseDwnldScartiAnomaliUpload>(_DwnldAnmSctUploadReturn_QNAME, ResponseDwnldScartiAnomaliUpload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FornituraRichiestaScartiAnomaliIn }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FornituraRichiestaScartiAnomaliIn }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "richiestaScrtAnmlFrnIn")
    public JAXBElement<FornituraRichiestaScartiAnomaliIn> createRichiestaScrtAnmlFrnIn(FornituraRichiestaScartiAnomaliIn value) {
        return new JAXBElement<FornituraRichiestaScartiAnomaliIn>(_RichiestaScrtAnmlFrnIn_QNAME, FornituraRichiestaScartiAnomaliIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseDwnldScartiAnomaliFornitura }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseDwnldScartiAnomaliFornitura }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.gaf.mds.com", name = "dwnldAnmSctFornituraReturn")
    public JAXBElement<ResponseDwnldScartiAnomaliFornitura> createDwnldAnmSctFornituraReturn(ResponseDwnldScartiAnomaliFornitura value) {
        return new JAXBElement<ResponseDwnldScartiAnomaliFornitura>(_DwnldAnmSctFornituraReturn_QNAME, ResponseDwnldScartiAnomaliFornitura.class, null, value);
    }

}
