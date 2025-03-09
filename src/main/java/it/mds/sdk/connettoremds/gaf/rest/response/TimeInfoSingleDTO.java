package it.mds.sdk.connettoremds.gaf.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TimeInfoSingleDTO {

    private String elabStep;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private String elabTime;
    private Long id;
}
