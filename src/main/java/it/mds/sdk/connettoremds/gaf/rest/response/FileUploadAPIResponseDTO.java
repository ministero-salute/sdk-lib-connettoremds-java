package it.mds.sdk.connettoremds.gaf.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileUploadAPIResponseDTO {

    private String result;
    private String message;
    private String errorCode;
    private String uploadId;

}
