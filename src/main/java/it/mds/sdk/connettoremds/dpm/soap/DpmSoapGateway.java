/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.dpm.soap;

import it.mds.sdk.connettoremds.conf.ConfigurazioneConnettoreMds;
import it.mds.sdk.connettoremds.dpm.webservice.bean.*;
import it.mds.sdk.connettoremds.dpm.webservice.bean.verifica.stato.DpmMdsResponse;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.parser.xml.ParserFirma;
import it.mds.sdk.connettoremds.parser.xml.exception.ValidazioneFirmaException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component("dpmSoapGateway")
public  class DpmSoapGateway {

    //01 identifica XML unico valore permesso
    private static final String TIPO_FILE_ALLEGATO ="01";
    final ConfigurazioneConnettoreMds config;
    ParserFirma parserFirma;

    public DpmSoapGateway(@Qualifier("parserFirma") final ParserFirma parserFirma) {
        this.config = new ConfigurazioneConnettoreMds();
        this.parserFirma = parserFirma;
    }

    public DpmInvioXmlRequest creaRequestInvioDpm(String idSoggAlimentante,
                                                  SoggettoAlimentanteType soggettoAlimentanteType,
                                                  TipoAttoType tipoAttoType,
                                                  String nomeFile){
        log.debug("{}.creaRequestInvioDpm - idSoggAlimentante[{}] - soggettoAlimentanteType[{}] - tipoAttoType[{}]- nomeFile[{}] -  BEGIN",
                this.getClass().getName(), idSoggAlimentante, soggettoAlimentanteType.toString(), tipoAttoType, nomeFile);

        ObjectFactory objectFactory = new ObjectFactory();
        DpmInvioXmlRequest dpmInvioXmlRequest = objectFactory.createDpmInvioXmlRequest();
        DpmInvioType dpmInvioType = objectFactory.createDpmInvioType();
        //soggetto alimentante
        dpmInvioType.setIdentificativoDatSoggettoAlimentante(idSoggAlimentante);
        dpmInvioType.setSoggettoAlimentante(soggettoAlimentanteType);
        dpmInvioType.setTipoAtto(tipoAttoType);
        //allegati
        AllegatiType allegatiType = objectFactory.createAllegatiType();
        AllegatoType allegatoType = objectFactory.createAllegatoType();
        allegatoType.setCidRef(nomeFile);
        allegatoType.setNome(nomeFile);
        allegatoType.setTipo(TIPO_FILE_ALLEGATO);
        allegatiType.setAllegato(allegatoType);
        dpmInvioType.setAllegati(allegatiType);

        dpmInvioXmlRequest.setDpmInvioMetaDati(dpmInvioType);
        return dpmInvioXmlRequest;
    }


    public DpmMdsResponse callInvioDpm(DpmInvioXmlRequest dpmInvioXmlRequest, String urlDPM, File tracciatoDPM, String user, String password, String idRun) throws ConnettoreMdsException {
        log.debug("{}.callInvioDpm - dpmInvioXmlRequest[{}] - urlDPM[{}] - tracciatoDPM[{}] -   BEGIN",
                this.getClass().getName(), dpmInvioXmlRequest.toString(), urlDPM, tracciatoDPM.getAbsolutePath());
        DpmOut dpmOut = new DpmOut();
        DpmMdsResponse dpmMdsResponse = new DpmMdsResponse();
        log.info("Url invioDpm "+ urlDPM);
        try {
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            //connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();

            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();


            SOAPHeader header = soapMessage.getSOAPHeader();
            createHeaderEnvelope(header, user, password);

            soapMessage.getMimeHeaders().addHeader("Content-Type", "multipart/related;");
            soapMessage.getMimeHeaders().addHeader("Content-Transfer-Encoding", "binary");

            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            JAXBContext jc = JAXBContextFactory.createContext(new Class[]{DpmInvioXmlRequest.class}, null);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(dpmInvioXmlRequest, soapBody);

            //Attachment
            URL url = tracciatoDPM.toURI().toURL();
            AttachmentPart ap = soapMessage.createAttachmentPart(new DataHandler(url));
            ap.setContentType("application/octet-stream");
            ap.setContentId(tracciatoDPM.getName());
            soapMessage.addAttachmentPart(ap);

            soapMessage.saveChanges();

            logSOAPMessage(soapMessage);

            SOAPMessage response = connection.call(soapMessage, new URL(urlDPM));

            log.info("Response Mds Invio Dpm");
            logSOAPMessage(response);

            SOAPBody soapBodyResponse = response.getSOAPBody();
            if (soapBodyResponse.getFault() == null) {
                scriviAttachment(response,config.getFromMds().getPercorsoFromMds(),idRun);
                dpmOut = leggiDpmAttachment(response,idRun);
                JAXBContext jcUnmarshaller = JAXBContextFactory.createContext(new Class[]{DpmInvioXmlResponse.class}, null);
                Unmarshaller unmarshaller = jcUnmarshaller.createUnmarshaller();
                DpmInvioXmlResponse dpmInvioXmlResponse = (DpmInvioXmlResponse) unmarshaller.unmarshal(soapBodyResponse.extractContentAsDocument());
                dpmMdsResponse.setNumeroAtto(dpmOut.getNumeroAtto());
                dpmMdsResponse.setIdentificativoSoggettoAlimentante(dpmOut.getIdentificativoSoggettoAlimentante());
                dpmMdsResponse.setTipoEsito(dpmOut.getTipoEsito());
                dpmMdsResponse.setDettagli(dpmOut.getDettagli());
                if(dpmInvioXmlResponse != null && dpmInvioXmlResponse.getDpmStatoContainer() != null && dpmInvioXmlResponse.getDpmStatoContainer().getDataEmissioneRicevuta() != null)
                    dpmMdsResponse.setDataEmissioneRicevuta(new Timestamp(dpmInvioXmlResponse.getDpmStatoContainer().getDataEmissioneRicevuta().toGregorianCalendar().getTimeInMillis()));

            } else {
                //TODO come gestire ?
                SOAPFault soapFault = soapBodyResponse.getFault();
                log.error(soapFault.getFaultString());
            }
            connection.close();

        } catch (SOAPException | JAXBException | IOException  e) {
            log.error("{}.callInvioDpm - dpmInvioXmlRequest[{}] - urlDPM[{}] - tracciatoDPM[{}]",
                    this.getClass().getName(), dpmInvioXmlRequest.toString(), urlDPM, tracciatoDPM.getAbsolutePath(), e);
            throw new ConnettoreMdsException("Errore nella chiamata al ministero " + e.getMessage(), e);
        }
        return dpmMdsResponse;
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
            log.error("{}.createHeaderEnvelope - header[{}] ",
                    this.getClass().getName(), header.toString(), e);
        }
    }


    public  DpmVerificaStatoXmlRequest creaRequestVerificaDpm( String idSoggAlimentante,
                                                                     SoggettoAlimentanteType soggettoAlimentanteType){
        log.debug("{}.creaRequestVerificaDpm - idSoggAlimentante[{}] - soggettoAlimentanteType[{}] -  BEGIN",
                this.getClass().getName(), idSoggAlimentante, soggettoAlimentanteType);
        DpmVerificaStatoXmlRequest dpmVerificaStatoXmlRequest = new DpmVerificaStatoXmlRequest();
        DpmVerificaStatoType dpmVerificaStatoType = new DpmVerificaStatoType();
        //soggetto alimentante
        dpmVerificaStatoType.setSoggettoAlimentante(soggettoAlimentanteType);
        dpmVerificaStatoType.setIdentificativoSoggettoAlimentante(idSoggAlimentante);
        dpmVerificaStatoXmlRequest.setDpmVerificaStatoMetaDati(dpmVerificaStatoType);
        return dpmVerificaStatoXmlRequest;
    }


    public  DpmMdsResponse callVerificaDpm(DpmVerificaStatoXmlRequest dpmVerificaStatoXmlRequest, String urlDPM,String user, String passwordMds, String idRun) throws ConnettoreMdsException {
        log.debug("{}.callVerificaDpm - dpmVerificaStatoXmlRequest[{}] - urlDPM[{}] -  BEGIN",
                this.getClass().getName(), dpmVerificaStatoXmlRequest.toString(), urlDPM);
        DpmOut dpmOut = new DpmOut();
        DpmMdsResponse dpmMdsResponse = new DpmMdsResponse();
        log.info("Url verificaDPM "+ urlDPM);
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
            createHeaderEnvelope(header,user,passwordMds);


            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            JAXBContext jc = JAXBContextFactory.createContext(new Class[]{DpmVerificaStatoXmlRequest.class}, null);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(dpmVerificaStatoXmlRequest, soapBody);

            //Attachment

            logSOAPMessage(soapMessage);

            SOAPMessage response = connection.call(soapMessage, new URL(urlDPM));
            log.info("Response Mds verifica dpm");
            logSOAPMessage(response);

            SOAPBody soapBodyResponse = response.getSOAPBody();

            if(soapBodyResponse.getFault()==null) {
                scriviAttachment(response,config.getFromMds().getPercorsoFromMds(),idRun);
                dpmOut = leggiDpmAttachment(response,idRun);
                JAXBContext jcUnmarshaller = JAXBContextFactory.createContext(new Class[]{DpmVerificaStatoXmlResponse.class}, null);
                Unmarshaller unmarshaller = jcUnmarshaller.createUnmarshaller();
                DpmVerificaStatoXmlResponse verificaStatoResponseXml = (DpmVerificaStatoXmlResponse) unmarshaller.unmarshal(soapBodyResponse.extractContentAsDocument());
                dpmMdsResponse.setNumeroAtto(dpmOut.getNumeroAtto());
                dpmMdsResponse.setIdentificativoSoggettoAlimentante(dpmOut.getIdentificativoSoggettoAlimentante());
                dpmMdsResponse.setTipoEsito(dpmOut.getTipoEsito());
                dpmMdsResponse.setDettagli(dpmOut.getDettagli());
                dpmMdsResponse.setDataEmissioneRicevuta(new Timestamp(verificaStatoResponseXml.getDpmStatoContainer().getDataEmissioneRicevuta().toGregorianCalendar().getTimeInMillis()));
            }else{
                //TODO come gestire ?

                SOAPFault soapFault =soapBodyResponse.getFault();
                log.error(soapFault.getFaultString());
            }
            connection.close();

        } catch (SOAPException | JAXBException |IOException e) {
            log.error("{}.callVerificaDpm - dpmVerificaStatoXmlRequest[{}] - urlDPM[{}]",
                    this.getClass().getName(), dpmVerificaStatoXmlRequest.toString(), urlDPM, e);
            throw new ConnettoreMdsException("Errore nella chiamata al ministero " + e.getMessage());
        }
        return dpmMdsResponse;
    }

    public  DpmOut leggiDpmAttachment(SOAPMessage soapMessage, String idRun) {
        log.debug("{}.leggiDpmAttachment -  BEGIN",
                this.getClass().getName());
        ObjectFactory objectFactory = new ObjectFactory();
        DpmOut dpmOut = objectFactory.createDpmOut();
        Iterator<AttachmentPart> iterator = soapMessage.getAttachments();
        try {
            while (iterator.hasNext()) {
                AttachmentPart attachment = iterator.next();
                JAXBContext jcUn = JAXBContextFactory.createContext(new Class[]{DpmOut.class}, null);
                Unmarshaller unmarshaller = jcUn.createUnmarshaller();
                //sfirmare
                String content = parserFirma.checkFirmaXmlP7MConn(new File(config.getFromMds().getPercorsoFromMds() + File.separator +idRun+"_"+ attachment.getContentId().replace("<","").replace(">","")));
                //return
                dpmOut = (DpmOut) unmarshaller.unmarshal(new ByteArrayInputStream(content.getBytes()));
            }

        } catch(JAXBException | ValidazioneFirmaException e) {
            log.error("{}.leggiDpmAttachment", this.getClass().getName(), e);
        }
        return dpmOut;
    }

    private  void logSOAPMessage(SOAPMessage message) throws SOAPException, IOException {
        log.debug("{}.logSOAPMessage - BEGIN",
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

    private void scriviAttachment(SOAPMessage soapMessage, String percorso, String idRun) {
        log.debug("{}.scriviAttachment - percorso[{}] - BEGIN",
                this.getClass().getName(),  percorso);
        Iterator<AttachmentPart> iterator = soapMessage.getAttachments();
        try {
            while (iterator.hasNext()) {
                AttachmentPart attachment = iterator.next();
                File outputFile = new File(percorso+ File.separator+ idRun+"_"+attachment.getContentId().replace("<","").replace(">",""));
                FileUtils.writeByteArrayToFile(outputFile, attachment.getRawContentBytes());
            }

        } catch(SOAPException | IOException e) {
            log.error("{}.scriviAttachment - percorso[{}] ",
                    this.getClass().getName(), percorso, e);
        }
    }
}
