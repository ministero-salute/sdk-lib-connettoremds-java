/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.gaf.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MonitorDTO {

    private String idUpload;
    private String sender;
    private String descSender;
    private String fileType;
    private String category;
    private Integer period;
    private OffsetDateTime periodDate;
    private Integer yearRif;
    private Integer elabState;
    private Integer outcomeState;
    private String fileName;
    private Integer archivedState;
    private String elabStateDesc;
    private String outcomeStateDesc;
    private String archivedStateDesc;
    private Boolean isXsdErrorPresent;
    private Boolean isDiscardedXMLPresent;
    private Boolean isDiscardedDetailsPresent;
    private Long id;
}
