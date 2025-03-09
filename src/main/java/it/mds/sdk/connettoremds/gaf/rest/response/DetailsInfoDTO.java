package it.mds.sdk.connettoremds.gaf.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DetailsInfoDTO {

    private String fileType;
    private String category;
    private String uploadId;
    private OffsetDateTime uploadDate;
    private String periodDesc;
    private Integer yearRif;
    private Integer elabState;
    private Boolean isXsdErrorPresent;
    private String outcomeState;
    private String elabETLState;
    private Integer archivedState;
    private String elabStateDesc;
    private String outcomeStateDesc;
    private String archivedStateDesc;
    private String fileDimInBytes;
    private Boolean isDiscardedOrAnomaly;
    private String fileDiscardedOrAnomaly;
    private Boolean isDiscardedXMLPresent;
    private Boolean isLimitDiscardedRowsPresent;
    private Integer numLimitDiscardedRows;
    private OffsetDateTime startDateElabGaf;
    private OffsetDateTime endDateElabGaf;
    private OffsetDateTime startDateElabEtl;
    private OffsetDateTime endDateElabEtl;
    private String sender;
    private String descSender;
    private String linkAnomalyReport;
    private String userNameSender;
    private String fiscalCodeSigner;
    private String fileName;
    private Boolean isDiscardedDetailsPresent;
    private Integer idTrattamento;
    private String monEsiUpload;
    private Long id;

}
