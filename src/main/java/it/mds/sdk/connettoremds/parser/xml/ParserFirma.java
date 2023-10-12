package it.mds.sdk.connettoremds.parser.xml;

import it.mds.sdk.connettoremds.parser.xml.exception.ValidazioneFirmaException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Data
@Slf4j
@Component("parserFirma")
public class ParserFirma {

 public String checkFirmaXmlP7MConn (File xmlToMds) throws ValidazioneFirmaException {
     log.debug("{}.checkFirmaXmlP7M - xmlToMds[{}] - BEGIN",
             this.getClass().getName(), xmlToMds.toString());
         ReadSignedFile read = new ReadSignedFile();

         byte[] fileData = new byte[(int) xmlToMds.length()];
         try (FileInputStream is = new FileInputStream(xmlToMds);
              DataInputStream dis = new DataInputStream(is)
         ) {
             dis.readFully(fileData);
         } catch (IOException e) {
             log.error("{}.checkFirmaXmlP7M - xmlToMds[{}] - BEGIN",
                     this.getClass().getName(), xmlToMds.toString(), e);
           throw new ValidazioneFirmaException(e.getMessage());
           //TODO lanciare eccezione
         }
         byte[] fileDataRead = read.getOriginalDocumentBinaries(fileData);
         return new String(fileDataRead);
 }

}
