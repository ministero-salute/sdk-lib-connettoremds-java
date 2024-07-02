/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.conf;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Slf4j
@Getter
public class ConfigurazioneConnettoreMds {
    UrlGAF urlGAF;
    UrlDPM urlDPM;
    GafTracciati gafTracciati;
    Esiti esiti;
    EsitiMx11 esitiMx11;
    Fus fus;
    UserInvio userInvio;
    PasswordInvio passwordInvio;
    UserInvioDpm userInvioDpm;
    PasswordInvioDpm passwordInvioDpm;
    FromMds fromMds;
    UrlDispovig urlDispovig;
    UserInvioDispovig userInvioDispovig;
    PasswordInvioDispovig passwordInvioDispovig;
    XmlOutput xmlOutput;


    private static final String FILE_CONF ="configConnettore.properties";

    public ConfigurazioneConnettoreMds() {
        this(leggiConfigurazioneEsterna());
    }

    public ConfigurazioneConnettoreMds(final Properties conf) {
        log.debug("{}.ConfigurazioneConnettoreMds - conf[{}] -  BEGIN",this.getClass().getName(), conf);
        // Imposta gli oggetti con le configurazioni lette dal file
        this.esiti = ConfigurazioneConnettoreMds.Esiti.builder()
                .withPercorsoEsiti(conf.getProperty("path.esiti", ""))
                .build();

        this.fus = ConfigurazioneConnettoreMds.Fus.builder()
                .withPercorsoFus(conf.getProperty("path.fus", ""))
                .build();

        this.urlGAF = ConfigurazioneConnettoreMds.UrlGAF.builder()
                .withUrlWebserviceGAF(conf.getProperty("url.webservice.gaf", ""))
                .build();

        this.urlDPM = ConfigurazioneConnettoreMds.UrlDPM.builder()
                .withUrlWebserviceDPM(conf.getProperty("url.webservice.dpm", ""))
                .build();
        this.gafTracciati = ConfigurazioneConnettoreMds.GafTracciati.builder()
                .withPercorsoGafTracciati(conf.getProperty("path.invio.tracciati.gaf", ""))
                .build();

        this.esitiMx11 = ConfigurazioneConnettoreMds.EsitiMx11.builder()
                .withPercorsoEsitimx11(conf.getProperty("path.esiti.mx11", ""))
                .build();
        this.userInvio = ConfigurazioneConnettoreMds.UserInvio.builder()
                .withUserInvioMds(conf.getProperty("user.invio.mds",""))
                .build();
        this.passwordInvio = ConfigurazioneConnettoreMds.PasswordInvio.builder()
                .withPasswordInvioMds(conf.getProperty("password.invio.mds",""))
                .build();
        this.userInvioDpm = ConfigurazioneConnettoreMds.UserInvioDpm.builder()
                .withUserInvioMdsDpm(conf.getProperty("user.invio.mds.dpm",""))
                .build();
        this.passwordInvioDpm = ConfigurazioneConnettoreMds.PasswordInvioDpm.builder()
                .withPasswordInvioMdsDpm(conf.getProperty("password.invio.mds.dpm",""))
                .build();
        this.fromMds = ConfigurazioneConnettoreMds.FromMds.builder()
                .withPercorsoFromMds(conf.getProperty("path.from.mds",""))
                .build();
        this.urlDispovig = ConfigurazioneConnettoreMds.UrlDispovig.builder()
                .withUrlWebserviceDispovig(conf.getProperty("url.webservice.dispovig", ""))
                .build();
        this.userInvioDispovig = ConfigurazioneConnettoreMds.UserInvioDispovig.builder()
                .withUserInvioMdsDispovig(conf.getProperty("user.invio.mds.dispovig",""))
                .build();
        this.passwordInvioDispovig = ConfigurazioneConnettoreMds.PasswordInvioDispovig.builder()
                .withPasswordInvioMdsDispovig(conf.getProperty("password.invio.mds.dispovig",""))
                .build();
        this.xmlOutput = ConfigurazioneConnettoreMds.XmlOutput.builder()
                .withPercorso(conf.getProperty("xmloutput.percorso", ""))
                .build();

    }

    private static Properties leggiConfigurazione(final String nomeFile) {
        log.debug("{}.leggiConfigurazione - nomeFile[{}] -  BEGIN",  ConfigurazioneConnettoreMds.class.getName(), nomeFile);
         Properties prop = new Properties();
        if(ConfigurazioneConnettoreMds.class.getClassLoader() == null){
            log.trace("{}.getClassLoader() is null", ConfigurazioneConnettoreMds.class);
            throw new NullPointerException();
        }
        try (final InputStream is = ConfigurazioneConnettoreMds.class.getClassLoader().getResourceAsStream(nomeFile)) {
            prop.load(is);
        } catch (IOException e) {
            log.error("{}.leggiConfigurazione - nomeFile[{}]", e.getClass().getName(), nomeFile, e);
        }
        return prop;
    }

    private static Properties leggiConfigurazioneEsterna() {
        log.debug("{}.leggiConfigurazioneEsterna - BEGIN", ConfigurazioneConnettoreMds.class.getName());
        Properties properties = new Properties();
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("/sdk/properties/connettore_mds.properties"), StandardCharsets.UTF_8))  {
            properties.load(in);
        } catch (IOException e) {
            log.error("{}.leggiConfigurazioneEsterna", ConfigurazioneConnettoreMds.class.getName(), e);
           return leggiConfigurazione(FILE_CONF);
        }
        return properties;
    }



    @Value
    @Builder(setterPrefix = "with")
    public static class UrlGAF {
        String urlWebserviceGAF;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class UrlDPM {
        String urlWebserviceDPM;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class Esiti {
        String percorsoEsiti;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class Fus {
        String percorsoFus;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class GafTracciati {
        String percorsoGafTracciati;
    }


    @Value
    @Builder(setterPrefix = "with")
    public static class EsitiMx11 {
        String percorsoEsitimx11;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class UserInvio {
        String userInvioMds;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class PasswordInvio {
        String passwordInvioMds;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class UserInvioDpm {
        String userInvioMdsDpm;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class PasswordInvioDpm {
        String passwordInvioMdsDpm;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class FromMds {
        String percorsoFromMds;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class UrlDispovig {
        String urlWebserviceDispovig;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class UserInvioDispovig {
        String userInvioMdsDispovig;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class PasswordInvioDispovig {
        String passwordInvioMdsDispovig;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class XmlOutput {
        String percorso;
    }
}
