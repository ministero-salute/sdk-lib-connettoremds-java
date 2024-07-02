/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds;

import it.mds.sdk.connettoremds.dpm.webservice.bean.SoggettoAlimentanteType;
import it.mds.sdk.connettoremds.dpm.webservice.bean.TipoAttoType;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


class ConnettoreMdsSOAPTest {
    private static final String TEST_XML = "TEST.xml";
    private static final String DIRETTA_XML = "diretta.xml";
    private static final String DIRETTA_1_XML = "diretta_1.xml";


    public void testInvioTracciati() throws MalformedURLException, ConnettoreMdsException {
        ConnettoreMdsSOAP connettoreMdsSOAP = new ConnettoreMdsSOAP(null,null,null);
      List<Path> tracciati = new ArrayList<>();
        tracciati.add(Paths.get("src", "test", "resources",DIRETTA_XML));
        tracciati.add(Paths.get("src", "test", "resources",DIRETTA_1_XML));
        String categoriaFlusso="DIR";
        String nomeFlusso="IF3";
        String periodoRiferimento="S1";
        String annoRiferimento="2022";

        //List<String> idsUpload =connettoreMdsSOAP.invioTracciati(tracciati,categoriaFlusso,nomeFlusso,periodoRiferimento,annoRiferimento);
       /* for(String id : idsUpload) {
            System.out.println("id upload Restituito " + id);
        }
*/
    }


   // @Test
    public void testInvioTracciatoDPM() throws MalformedURLException, ConnettoreMdsException {
        ConnettoreMdsSOAP connettoreMdsSOAP = new ConnettoreMdsSOAP(null,null,null);
        Path tracciatoDPM =Paths.get("src", "test", "resources",TEST_XML);

        SoggettoAlimentanteType soggettoAlimentanteType = new SoggettoAlimentanteType();
        soggettoAlimentanteType.setCodiceSoggettoAlimentante("120202");
        soggettoAlimentanteType.setRegioneSoggettoAlimentante("150");
        soggettoAlimentanteType.setCap("12345");
        soggettoAlimentanteType.setIndirizzo("VIA FILIPPO MEDA, 35");

        connettoreMdsSOAP.invioTracciatoDonazionePostMortem(tracciatoDPM.toFile(),
                                            "00001",
                                            soggettoAlimentanteType,
                TipoAttoType.MANIFESTAZIONE_CONSENSO,"1");
    }


}