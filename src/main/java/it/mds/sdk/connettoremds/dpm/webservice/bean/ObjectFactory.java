//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.06.08 alle 02:52:56 PM CEST 
//


package it.mds.sdk.connettoremds.dpm.webservice.bean;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.codejournal.maven.xsd2java package. 
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

    private final static QName _DpmStatoContainerTypeNumeroAtto_QNAME = new QName("http://be.dpm.mds.it", "numeroAtto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.codejournal.maven.xsd2java
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DpmInvioXmlRequest }
     * 
     */
    public DpmInvioXmlRequest createDpmInvioXmlRequest() {
        return new DpmInvioXmlRequest();
    }

    /**
     * Create an instance of {@link DpmInvioType }
     * 
     */
    public DpmInvioType createDpmInvioType() {
        return new DpmInvioType();
    }

    /**
     * Create an instance of {@link DpmInvioXmlResponse }
     * 
     */
    public DpmInvioXmlResponse createDpmInvioXmlResponse() {
        return new DpmInvioXmlResponse();
    }

    /**
     * Create an instance of {@link DpmStatoContainerType }
     * 
     */
    public DpmStatoContainerType createDpmStatoContainerType() {
        return new DpmStatoContainerType();
    }

    /**
     * Create an instance of {@link DpmVerificaStatoXmlRequest }
     * 
     */
    public DpmVerificaStatoXmlRequest createDpmVerificaStatoXmlRequest() {
        return new DpmVerificaStatoXmlRequest();
    }

    /**
     * Create an instance of {@link DpmVerificaStatoType }
     * 
     */
    public DpmVerificaStatoType createDpmVerificaStatoType() {
        return new DpmVerificaStatoType();
    }

    /**
     * Create an instance of {@link DpmVerificaStatoXmlResponse }
     * 
     */
    public DpmVerificaStatoXmlResponse createDpmVerificaStatoXmlResponse() {
        return new DpmVerificaStatoXmlResponse();
    }

    /**
     * Create an instance of {@link DpmOut }
     * 
     */
    public DpmOut createDpmOut() {
        return new DpmOut();
    }

    /**
     * Create an instance of {@link DettaglioType }
     * 
     */
    public DettaglioType createDettaglioType() {
        return new DettaglioType();
    }

    /**
     * Create an instance of {@link Dpm }
     * 
     */
    public Dpm createDpm() {
        return new Dpm();
    }

    /**
     * Create an instance of {@link AnagrafePersonaType }
     * 
     */
    public AnagrafePersonaType createAnagrafePersonaType() {
        return new AnagrafePersonaType();
    }

    /**
     * Create an instance of {@link SoggettoAlimentanteType }
     * 
     */
    public SoggettoAlimentanteType createSoggettoAlimentanteType() {
        return new SoggettoAlimentanteType();
    }

    /**
     * Create an instance of {@link AllegatiType }
     * 
     */
    public AllegatiType createAllegatiType() {
        return new AllegatiType();
    }

    /**
     * Create an instance of {@link AllegatoType }
     * 
     */
    public AllegatoType createAllegatoType() {
        return new AllegatoType();
    }

    /**
     * Create an instance of {@link AnagrafeGeoType }
     * 
     */
    public AnagrafeGeoType createAnagrafeGeoType() {
        return new AnagrafeGeoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://be.dpm.mds.it", name = "numeroAtto", scope = DpmStatoContainerType.class)
    public JAXBElement<String> createDpmStatoContainerTypeNumeroAtto(String value) {
        return new JAXBElement<String>(_DpmStatoContainerTypeNumeroAtto_QNAME, String.class, DpmStatoContainerType.class, value);
    }

}
