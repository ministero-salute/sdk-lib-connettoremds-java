
package it.mds.sdk.connettoremds.gaf.webservices.port;

import it.mds.sdk.connettoremds.gaf.webservices.bean.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 *
 */
@WebService(name = "GAFWS", targetNamespace = "http://webservices.gaf.mds.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public interface GAFWS {


    /**
     *
     * @param informazioniFlusso
     * @return
     *     returns com.gaf.ws.client.ResponseUploadFile
     */
    @WebMethod
    @WebResult(name = "invioFlussiReturn", targetNamespace = "http://webservices.gaf.mds.com", partName = "invioFlussiReturn")
    public ResponseUploadFile invioFlussi(
            @WebParam(name = "informazioniFlusso", targetNamespace = "http://webservices.gaf.mds.com", partName = "informazioniFlusso")
                    InformazioniFlusso informazioniFlusso);

    /**
     *
     * @param listaUpload
     * @return
     *     returns com.gaf.ws.client.ResponseUploadMonitoraggio
     */
    @WebMethod
    @WebResult(name = "monEsiUploadReturn", targetNamespace = "http://webservices.gaf.mds.com", partName = "monEsiUploadReturn")
    public ResponseUploadMonitoraggio monEsiUpload(
            @WebParam(name = "listaUpload", targetNamespace = "http://webservices.gaf.mds.com", partName = "listaUpload")
                    UploadMonitoraggioIn listaUpload);

    /**
     *
     * @param identificativoFornitura
     * @return
     *     returns com.gaf.ws.client.ResponseFornituraMonitoraggio
     */
    @WebMethod
    @WebResult(name = "monEsiFornituraReturn", targetNamespace = "http://webservices.gaf.mds.com", partName = "monEsiFornituraReturn")
    public ResponseFornituraMonitoraggio monEsiFornitura(
            @WebParam(name = "identificativoFornitura", targetNamespace = "http://webservices.gaf.mds.com", partName = "identificativoFornitura")
                    String identificativoFornitura);

    /**
     *
     * @param listaUploadXML
     * @return
     *     returns com.gaf.ws.client.ResponseUploadXML
     */
    @WebMethod
    @WebResult(name = "monEsiUploadXMLReturn", targetNamespace = "http://webservices.gaf.mds.com", partName = "monEsiUploadXMLReturn")
    public ResponseUploadXML monEsiUploadXML(
            @WebParam(name = "listaUploadXML", targetNamespace = "http://webservices.gaf.mds.com", partName = "listaUploadXML")
                    UploadMonitoraggioIn listaUploadXML);

    /**
     *
     * @param identificativoFornituraXML
     * @return
     *     returns com.gaf.ws.client.ResponseFornituraXML
     */
    @WebMethod
    @WebResult(name = "monEsiFornituraXMLReturn", targetNamespace = "http://webservices.gaf.mds.com", partName = "monEsiFornituraXMLReturn")
    public ResponseFornituraXML monEsiFornituraXML(
            @WebParam(name = "identificativoFornituraXML", targetNamespace = "http://webservices.gaf.mds.com", partName = "identificativoFornituraXML")
                    String identificativoFornituraXML);

    /**
     *
     * @param richiestaScrtAnmlIn
     * @return
     *     returns com.gaf.ws.client.ResponseDwnldScartiAnomaliUpload
     */
    @WebMethod
    @WebResult(name = "dwnldAnmSctUploadReturn", targetNamespace = "http://webservices.gaf.mds.com", partName = "dwnldAnmSctUploadReturn")
    public ResponseDwnldScartiAnomaliUpload dwnldAnmSctUpload(
            @WebParam(name = "richiestaScrtAnmlIn", targetNamespace = "http://webservices.gaf.mds.com", partName = "richiestaScrtAnmlIn")
            UploadRichiestaScartiAnomaliIn richiestaScrtAnmlIn);

    /**
     *
     * @param richiestaScrtAnmlFrnIn
     * @return
     *     returns com.gaf.ws.client.ResponseDwnldScartiAnomaliFornitura
     */
    @WebMethod
    @WebResult(name = "dwnldAnmSctFornituraReturn", targetNamespace = "http://webservices.gaf.mds.com", partName = "dwnldAnmSctFornituraReturn")
    public ResponseDwnldScartiAnomaliFornitura dwnldAnmSctFornitura(
            @WebParam(name = "richiestaScrtAnmlFrnIn", targetNamespace = "http://webservices.gaf.mds.com", partName = "richiestaScrtAnmlFrnIn")
                    FornituraRichiestaScartiAnomaliIn richiestaScrtAnmlFrnIn);

}
