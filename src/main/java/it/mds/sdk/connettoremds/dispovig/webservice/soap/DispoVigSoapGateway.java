/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.dispovig.webservice.soap;

import it.mds.sdk.connettoremds.dispovig.webservice.bean.ObjectFactory;
import it.mds.sdk.connettoremds.dispovig.webservice.bean.UploadFile;
import it.mds.sdk.connettoremds.dispovig.webservice.bean.UploadFileResponse;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component("dispoVigSoapGateway")
public class DispoVigSoapGateway {
    public UploadFile creaRequestInvioDispovig(String nomeFile, String percorso){
        log.debug("{}.creaRequestInvioDpm - tracciato[{}]  -  BEGIN", this.getClass().getName(), nomeFile);

        ObjectFactory objectFactory = new ObjectFactory();
        UploadFile uploadFileRequest = objectFactory.createUploadFile();
        uploadFileRequest.setNomeFile(nomeFile);
        try {
            byte[] arrayByteFile = Files.readAllBytes(Paths.get(percorso+nomeFile));
            JAXBElement<byte[]> fileDaInviare = objectFactory.createUploadFileFile(arrayByteFile);
            uploadFileRequest.setFile(fileDaInviare.getValue());
        } catch (IOException e) {
            log.debug("Errore creazione Request Dispovig",e);
        }

        return uploadFileRequest;
    }



    public UploadFileResponse callUploadFileDispovig(UploadFile uploadFileRequest, String urlDispovig, String user, String password) throws ConnettoreMdsException {
        log.debug("{}.callUploadFileDispovig - uploadFileRequest[{}] - urlDispovig[{}] -  BEGIN",
                this.getClass().getName(), uploadFileRequest.toString(), urlDispovig);
        ObjectFactory objectFactory = new ObjectFactory();
        UploadFileResponse responseUpload = objectFactory.createUploadFileResponse();
        try {
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            //connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();

            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();

            // SOAP Header
            SOAPHeader header = soapMessage.getSOAPHeader();
            createHeaderEnvelope(header, user, password);


            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            SOAPElement uploadFile = null;
            uploadFile = soapBody.addChildElement("uploadFile", "ser", "http://service.dispovig.sdk.eng.it/");
            JAXBContext jc = JAXBContextFactory.createContext(new Class[]{UploadFile.class}, null);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(uploadFileRequest, uploadFile);

            //Attachment

            logSOAPMessage(soapMessage);

            SOAPMessage response = connection.call(soapMessage, new URL(urlDispovig));
            log.info("Response callUploadFileDispovig");
            logSOAPMessage(response);

            SOAPBody soapBodyResponse = response.getSOAPBody();


            JAXBContext jcUnmarshaller = JAXBContextFactory.createContext(new Class[]{UploadFileResponse.class}, null);
            Unmarshaller unmarshaller = jcUnmarshaller.createUnmarshaller();
            responseUpload = (UploadFileResponse) unmarshaller.unmarshal(soapBodyResponse.extractContentAsDocument());

            connection.close();

        } catch (SOAPException | JAXBException | IOException e) {
            log.error("{}.callUploadFileDispovig - UploadFileRequest[{}] - urlDispovig[{}]",
                    this.getClass().getName(), uploadFileRequest.toString(), urlDispovig,  e);
            throw new ConnettoreMdsException("Errore nella chiamata al ministero " + e.getMessage());
        }
        return responseUpload;
    }

    private  void logSOAPMessage(SOAPMessage message) throws SOAPException, IOException {
        log.debug("{}.logSOAPMessage -  BEGIN",
                this.getClass().getName());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        message.writeTo(bout);
        String msg = bout.toString(StandardCharsets.UTF_8);
        try {
            @SuppressWarnings("squid:S5852")
            Pattern patternSecurity = Pattern.compile("<wsse:Security.*?>(.*?)</wsse:Security>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = patternSecurity.matcher(msg);
            boolean matchFound = matcher.find();
            if (matchFound) {
                String toBeReplaced = matcher.group(1);
                log.info(":: Logging SOAP Message :: " + msg.replace(toBeReplaced,"*****"));
            }else{
                log.info(":: Logging SOAP Message :: " + msg);
            }
        }catch (Exception e){
            log.error("Errore durante la sostituzione del messaggio SOAP", e);
        }
    }

    private  void createHeaderEnvelope(SOAPHeader header, String user, String passwordMds){
        log.debug("{}.createHeaderEnvelope -  BEGIN",
                this.getClass().getName());
        SOAPElement security = null;
        String creatTime = ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT );
        try {
            security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

            SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
            usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            usernameToken.addAttribute(new QName("wsu:Id"), "UsernameToken-4");
            SOAPElement username = usernameToken.addChildElement("Username", "wsse");
            username.addTextNode(user);

            @SuppressWarnings("squid:S2068")
            SOAPElement password = usernameToken.addChildElement("Password", "wsse");
            password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

            password.addTextNode(passwordMds);

            SOAPElement created = usernameToken.addChildElement("Created", "wsu","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

            created.addTextNode(creatTime);

        } catch (SOAPException e) {
            log.error("{}.createHeaderEnvelope - header[{}]",
                    this.getClass().getName(), header.toString(), e);
        }
    }
}
