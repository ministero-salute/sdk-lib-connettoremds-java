/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.gaf.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordInfoSingleDTO {

    private String elabStep;
    private Integer numRecordDone;
    private Integer percRecordDone;
    private Integer numRecordError;
    private Integer percRecordError;
    private Integer numRecordDiscarded;
    private Integer percRecordDiscarded;
    private Integer numRecordTotal;
    private Integer percRecordTotal;
    private Long id;
}
