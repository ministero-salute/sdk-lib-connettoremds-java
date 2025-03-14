/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.dispovig.webservice.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.mds.sdk.client package. 
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

    private final static QName _UploadFile_QNAME = new QName("http://service.dispovig.sdk.eng.it/", "uploadFile");
    private final static QName _UploadFileResponse_QNAME = new QName("http://service.dispovig.sdk.eng.it/", "uploadFileResponse");
    private final static QName _UploadFileFile_QNAME = new QName("", "file");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.mds.sdk.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadFile }
     * 
     */
    public UploadFile createUploadFile() {
        return new UploadFile();
    }

    /**
     * Create an instance of {@link UploadFileResponse }
     * 
     */
    public UploadFileResponse createUploadFileResponse() {
        return new UploadFileResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.dispovig.sdk.eng.it/", name = "uploadFile")
    public JAXBElement<UploadFile> createUploadFile(UploadFile value) {
        return new JAXBElement<UploadFile>(_UploadFile_QNAME, UploadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.dispovig.sdk.eng.it/", name = "uploadFileResponse")
    public JAXBElement<UploadFileResponse> createUploadFileResponse(UploadFileResponse value) {
        return new JAXBElement<UploadFileResponse>(_UploadFileResponse_QNAME, UploadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "file", scope = UploadFile.class)
    public JAXBElement<byte[]> createUploadFileFile(byte[] value) {
        return new JAXBElement<byte[]>(_UploadFileFile_QNAME, byte[].class, UploadFile.class, ((byte[]) value));
    }

}
