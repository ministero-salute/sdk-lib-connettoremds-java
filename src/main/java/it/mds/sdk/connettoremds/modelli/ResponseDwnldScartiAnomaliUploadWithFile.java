package it.mds.sdk.connettoremds.modelli;

import it.mds.sdk.connettoremds.gaf.webservices.bean.ResponseDwnldScartiAnomaliUpload;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ResponseDwnldScartiAnomaliUploadWithFile {

    private ResponseDwnldScartiAnomaliUpload responseDwnldScartiAnomaliUpload;
    private List<String> nomiFile;
}
