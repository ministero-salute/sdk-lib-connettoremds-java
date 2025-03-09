package it.mds.sdk.connettoremds.gaf.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MonitoringResponseDTO {

    private Integer totalPages;
    private Long totalElements;
    private List<MonitorDTO> uploadList;
}
