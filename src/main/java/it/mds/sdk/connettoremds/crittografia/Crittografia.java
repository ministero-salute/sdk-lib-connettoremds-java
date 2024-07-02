/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.crittografia;

import it.gov.salute.interconnessione.api.core.InterconnessioneApi;
import it.mds.sdk.connettoremds.exception.CrittografiaException;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class Crittografia {

    private InterconnessioneApi interconnessioneApi;

    public Crittografia(InterconnessioneApi interconnessioneApi) {
        this.interconnessioneApi = interconnessioneApi;
    }

    public static Crittografia getInstanceInterconnessioneDefault() throws CrittografiaException {
        try {
            return new Crittografia(InterconnessioneApi.getInstance());
        } catch (Exception e) {
            log.error("impossibile create istanza di InterconnessioneAPI");
            throw new CrittografiaException("impossibile creare istanza InterconnnessioneAPI", e);
        }
    }

    /**
     * Metodo che cripta il file passato in input fileDaCriptare utilizzando il certificato, anch'esso passato in input
     * cert e genera il file criptato a partire dal path fileOutput.
     * L'algoritmo di cifratura è gestito da una classe interna ed è specifica per il flusso preso in considerazione,
     * in sostanza non è possilbile specificarne uno diverso.
     * Nel caso in cui i file non fossero presenti viene lanciata una CrittografiaException
     *
     * @param fileDaCriptare il file da criptare
     * @param fileOutput     il file dove scrivere il risultato della cifratura
     * @param cert           il certificato con cui cifrare il file di input
     * @return il file cifrato
     * @throws CrittografiaException lanciata in caso di errore in fase di cifratura o di lettura file
     */
    public Path criptaFile(Path fileDaCriptare, Path fileOutput, Path cert) throws CrittografiaException {
        try (InputStream isFile = Files.newInputStream(fileDaCriptare);
             InputStream isCert = Files.newInputStream(cert);
             OutputStream osRes = Files.newOutputStream(fileOutput)) {
            log.debug("Inizio cript file {} con cert {}", fileDaCriptare.getFileName(), cert.getFileName());
            interconnessioneApi.cifraFile(isFile, isCert, osRes);
            Path fileCriptato = fileOutput.toAbsolutePath();
            log.info("Cifratura file {} avvenuta con successo. Generato file {}", fileDaCriptare.getFileName(),
                    fileCriptato.getFileName());
            return fileCriptato;
        } catch (Exception e) {
            throw new CrittografiaException("Impossibile criptare il file", e);
        }
    }

    /**
     * Metodo che cripta il file di ingresso con il certificato producendo un file di uscita che ha lo stesso nome del
     * file di input con in aggiunta l'estensione p7m.
     * Il metodo svolge le stesse funzioni di quello con 3 parametri.
     *
     * @param fileDaCriptare il file da criptare
     * @param cert           il certificato da utilizzare per criptare
     * @return il file criptato con nome uguale a quello di ingresso con aggiunta estensione p7m
     * @throws CrittografiaException lanciata in caso non sia possibile leggere i file o errori di cifratura
     */
    public Path criptaFile(Path fileDaCriptare, Path cert) throws CrittografiaException {
        String file = fileDaCriptare.toAbsolutePath() + ".p7m";
        log.debug("Il file di output per il file {} è {}", fileDaCriptare.getFileName(), file);
        Path fileOutput = Paths.get(file);
        return criptaFile(fileDaCriptare, fileOutput, cert);
    }
}
