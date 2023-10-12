package it.mds.sdk.connettoremds.crittografia;

import it.gov.salute.interconnessione.api.core.InterconnessioneApi;
import it.mds.sdk.connettoremds.exception.CrittografiaException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CrittografiaTest {

    private Crittografia crittografia;

    @BeforeEach
    void initCrittografiaNoMock() throws Exception {
        crittografia = new Crittografia(InterconnessioneApi.getInstance());
    }

    @AfterEach
    void cancellap7m() {
        try {
            Files.delete(Paths.get("src", "test", "resources", "prova.xml.p7m"));
        } catch (IOException e) {
        }
    }

    @Test
    void criptoFileOK() throws CrittografiaException, IOException {

        Path fileDaCriptare = Paths.get("src", "test", "resources", "prova.xml");
        Path cert = Paths.get("src", "test", "resources", "cert_test.crt");
        Path fileOutput = Paths.get("src", "test", "resources", "prova.xml.p7m");

        Path fileCriptato = crittografia.criptaFile(fileDaCriptare, fileOutput, cert);

        Assertions.assertTrue(fileCriptato.toFile().exists());
    }

    @Test
    void criptoFileNOCertificatoException() {

        Path fileDaCriptare = Paths.get("src", "test", "resources", "prova.xml");
        Path cert = Paths.get("src", "test", "resources", "nonpresente.crt");
        Path fileOutput = Paths.get("src", "test", "resources", "prova.xml.p7m");

        Assertions.assertThrows(CrittografiaException.class, () -> crittografia.criptaFile(fileDaCriptare, fileOutput,
                cert));
    }

    @Test
    void criptoFileNoInputException() {
        Path fileDaCriptare = Paths.get("src", "test", "resources", "nonesiste.xml");
        Path cert = Paths.get("src", "test", "resources", "cert_test.crt");
        Path fileOutput = Paths.get("src", "test", "resources", "prova.xml.p7m");

        Assertions.assertThrows(CrittografiaException.class, () -> crittografia.criptaFile(fileDaCriptare, fileOutput,
                cert));
    }

    @Test
    void criptoFileOutputNonCreatoException() throws Exception {
        Path fileDaCriptare = Paths.get("src", "test", "resources", "prova.xml");
        Path cert = Paths.get("src", "test", "resources", "cert_test.crt");
        Path fileOutput = Paths.get("src", "test", "resources", "prova.xml.p7m");
        InterconnessioneApi interconnessioneApi = mock(InterconnessioneApi.class);
        Crittografia crittografia = new Crittografia(interconnessioneApi);

        doThrow(new Exception()).when(interconnessioneApi).cifraFile(any(), any(), any());

        Assertions.assertThrows(CrittografiaException.class, () -> crittografia.criptaFile(fileDaCriptare, fileOutput,
                cert));
    }

    @Test
    void critpoFileOutputCambioNomeOk() throws CrittografiaException {
        Path fileDaCriptare = Paths.get("src", "test", "resources", "prova.xml");
        Path cert = Paths.get("src", "test", "resources", "cert_test.crt");

        Path pathOutput = crittografia.criptaFile(fileDaCriptare, cert);

        Assertions.assertTrue(pathOutput.endsWith("prova.xml.p7m"));
    }
}
