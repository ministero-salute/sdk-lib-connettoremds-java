package it.mds.sdk.connettoremds.gaf.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DetailsResponseDTO {

    private List<DetailsInfoDTO> detailsInfo;
    private List<TimeInfoSingleDTO> timeInfo;
    private List<RecordInfoSingleDTO> recordInfo;
    private TracciatiInfoDTO tracciatiInfo;
}
