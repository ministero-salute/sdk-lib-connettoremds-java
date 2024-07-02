/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.dpm.webservice.bean.verifica.stato;

import it.mds.sdk.connettoremds.dpm.webservice.bean.DpmOut;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class DpmMdsResponse extends DpmOut {

    Timestamp dataEmissioneRicevuta;
}
