package it.mds.sdk.connettoremds;

import it.mds.sdk.connettoremds.dispovig.webservice.soap.DispoVigSoapGateway;
import it.mds.sdk.connettoremds.dpm.soap.DpmSoapGateway;
import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import it.mds.sdk.connettoremds.gaf.webservices.soap.GafSoapGateway;
import it.mds.sdk.connettoremds.modelli.ResponseDownload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RitornoIntegrationTest {

    private ConnettoreMdsSOAP con;
    private GafSoapGateway gaf;
    private DpmSoapGateway dpm;
    private DispoVigSoapGateway dispo;

    @BeforeEach
    void init() {
        gaf = new GafSoapGateway();
        con = new ConnettoreMdsSOAP(dpm , gaf, dispo);
    }
    @Disabled
    @Test
    void fusDownload() throws ConnettoreMdsException {
        List<String> id = new ArrayList<>();
        id.add("1111");

        ResponseDownload res =  con.downloadFus(id);
        res.getEsiti();
    }
}
