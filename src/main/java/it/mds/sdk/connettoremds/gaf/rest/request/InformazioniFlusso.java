package it.mds.sdk.connettoremds.gaf.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InformazioniFlusso {

    private String categoriaFlusso;
    private String nomeFlusso;
    private String periodoRiferimento;
    private String annoRiferimento;
}
