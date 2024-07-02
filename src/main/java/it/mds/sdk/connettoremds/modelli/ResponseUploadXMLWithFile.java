/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.modelli;


import it.mds.sdk.connettoremds.gaf.webservices.bean.ResponseUploadXML;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ResponseUploadXMLWithFile {

    private ResponseUploadXML responseUploadXML;
    private List<String> nomiFile;
}
