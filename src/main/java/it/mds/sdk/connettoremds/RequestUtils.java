/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds;

import it.mds.sdk.connettoremds.exception.ConnettoreMdsException;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;

@Slf4j
public abstract class RequestUtils {

    private static final String CATEGORIA_FLUSSI_SISM_RES = "RES";

    private static final String CATEGORIA_FLUSSI_DIR = "DIR";
    private static final String CATEGORIA_FLUSSI_AVN_NONSOMMMOB = "AVT";
    private static final String CATEGORIA_FLUSSI_AVN_NONSOMMRES = "AVN";

    private static final String CATEGORIA_FLUSSI_AVN_SOMMRES = "AVN";

    private static final String CATEGORIA_FLUSSI_AVN_SOMMMOB = "AVT";
    private static final String CATEGORIA_FLUSSI_SISM_TER = "TER";

    private static final String CATEGORIA_FLUSSI_OSP = "OSP";

    private static final String CATEGORIA_FLUSSI_CNS_CT2 = "CDM";

    private static final String NOME_FLUSSO_ANAGRAFICA_SISMRES = "ANR";
    private static final String NOME_FLUSSO_CONTATTO_SISMRES = "CNR";

    private static final String NOME_FLUSSO_DIR = "IF3";

    private static final String NOME_FLUSSO_OSP = "OSP";

    private static final String NOME_FLUSSO_CNS = "CNS";

    private static final String NOME_FLUSSO_CT2 = "CT2";
    private static final String NOME_FLUSSO_PRESTAZIONE_SISMRES = "PSR";
    private static final String NOME_FLUSSO_PRESTAZIONE_SISMSEMIRES = "PSS";

    private static final String NOME_FLUSSO_ANAGRAFICA_SISMTER = "ANT";
    private static final String NOME_FLUSSO_CONTATTO_SISMTER = "CNT";
    private static final String NOME_FLUSSO_PRESTAZIONE_SISMTER = "PST";


    private static final String NOME_FLUSSO_ANAGRAFICA_AVN_NONSOMMMOB = "AVM";
    private static final String NOME_FLUSSO_PRNONEFF_AVN_NONSOMMMOB = "VNM";
    private static final String NOME_FLUSSO_PRNONEFF_AVN_SOMMMOB = "VSM";
    private static final String NOME_FLUSSO_ANAGRAFICA_AVN_NONSOMMRES = "AVX";
    private static final String NOME_FLUSSO_PRNONEFF_AVN_NONSOMMRES = "VNX";
    private static final String NOME_FLUSSO_PRNONEFF_AVN_SOMMRES = "VSX";


    public static String nomeFlussoInvio(String categoriaFlusso, String nomeFlusso, Path tracciato) throws ConnettoreMdsException {
        String nomeFlussoInvio = nomeFlusso;
        if (CATEGORIA_FLUSSI_SISM_RES.equals(categoriaFlusso) || CATEGORIA_FLUSSI_SISM_TER.equals(categoriaFlusso)) {
            nomeFlussoInvio = getNomeFlussoSism(categoriaFlusso, nomeFlusso, tracciato);
        } else if (CATEGORIA_FLUSSI_AVN_NONSOMMMOB.equals(categoriaFlusso) || CATEGORIA_FLUSSI_AVN_NONSOMMRES.equals(categoriaFlusso)
                || CATEGORIA_FLUSSI_AVN_SOMMRES.equals(categoriaFlusso) || CATEGORIA_FLUSSI_AVN_SOMMMOB.equals(categoriaFlusso)) {
            nomeFlussoInvio = getNomeFlussoAvn(categoriaFlusso, nomeFlusso, tracciato);
        } else if (CATEGORIA_FLUSSI_DIR.equals(categoriaFlusso) || CATEGORIA_FLUSSI_OSP.equals(categoriaFlusso)) {
            nomeFlussoInvio = getNomeFlussoDir(categoriaFlusso, nomeFlusso, tracciato);
        }else if (CATEGORIA_FLUSSI_CNS_CT2.equals(categoriaFlusso)) {
            nomeFlussoInvio = getNomeFlussoCnsCt2(categoriaFlusso, nomeFlusso, tracciato);
        }
        return nomeFlussoInvio;
    }

    private static String getNomeFlussoSism(String categoriaFlusso, String nomeFlusso, Path path) throws ConnettoreMdsException {

        log.debug("Categoria Flusso {} - path {}", categoriaFlusso, path.toString());

        if (CATEGORIA_FLUSSI_SISM_RES.equals(categoriaFlusso)) {
            if (path.toString().contains(NOME_FLUSSO_ANAGRAFICA_SISMRES)) {
                return NOME_FLUSSO_ANAGRAFICA_SISMRES;
            } else if (path.toString().contains(NOME_FLUSSO_CONTATTO_SISMRES)) {
                return NOME_FLUSSO_CONTATTO_SISMRES;
            } else if (path.toString().contains(NOME_FLUSSO_PRESTAZIONE_SISMRES)) {
                return NOME_FLUSSO_PRESTAZIONE_SISMRES;
            } else if (path.toString().contains(NOME_FLUSSO_PRESTAZIONE_SISMSEMIRES)) {
                return NOME_FLUSSO_PRESTAZIONE_SISMSEMIRES;
            } else {
                log.error("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
                throw new ConnettoreMdsException("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
            }
        }
        if (CATEGORIA_FLUSSI_SISM_TER.equals(categoriaFlusso)) {
            if (path.toString().contains(NOME_FLUSSO_ANAGRAFICA_SISMTER)) {
                return NOME_FLUSSO_ANAGRAFICA_SISMTER;
            } else if (path.toString().contains(NOME_FLUSSO_CONTATTO_SISMTER)) {
                return NOME_FLUSSO_CONTATTO_SISMTER;
            } else if (path.toString().contains(NOME_FLUSSO_PRESTAZIONE_SISMTER)) {
                return NOME_FLUSSO_PRESTAZIONE_SISMTER;
            } else {
                log.error("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
                throw new ConnettoreMdsException("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
            }
        }
        return nomeFlusso;
    }

    private static String getNomeFlussoAvn(String categoriaFlusso, String nomeFlusso, Path path) throws ConnettoreMdsException {
        log.debug("Categoria Flusso {} - path {}", categoriaFlusso, path.toString());

        if (CATEGORIA_FLUSSI_AVN_NONSOMMMOB.equals(categoriaFlusso)) {
            if (path.toString().contains(NOME_FLUSSO_ANAGRAFICA_AVN_NONSOMMMOB)) {
                return NOME_FLUSSO_ANAGRAFICA_AVN_NONSOMMMOB;
            } else if (path.toString().contains(NOME_FLUSSO_PRNONEFF_AVN_SOMMMOB)) {
                return NOME_FLUSSO_PRNONEFF_AVN_SOMMMOB;
            } else if (path.toString().contains(NOME_FLUSSO_PRNONEFF_AVN_NONSOMMMOB)) {
                return NOME_FLUSSO_PRNONEFF_AVN_NONSOMMMOB;
            } else {
                log.error("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
                throw new ConnettoreMdsException("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
            }
        }

        if (CATEGORIA_FLUSSI_AVN_NONSOMMRES.equals(categoriaFlusso)) {
            if (path.toString().contains(NOME_FLUSSO_ANAGRAFICA_AVN_NONSOMMRES)) {
                return NOME_FLUSSO_ANAGRAFICA_AVN_NONSOMMRES;
            } else if (path.toString().contains(NOME_FLUSSO_PRNONEFF_AVN_NONSOMMRES)) {
                return NOME_FLUSSO_PRNONEFF_AVN_NONSOMMRES;
            } else if (path.toString().contains(NOME_FLUSSO_PRNONEFF_AVN_SOMMRES)) {
                return NOME_FLUSSO_PRNONEFF_AVN_SOMMRES;
            } else {
                log.error("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
                throw new ConnettoreMdsException("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
            }
        }
        return nomeFlusso;
    }

    private static String getNomeFlussoDir(String categoriaFlusso, String nomeFlusso, Path path) throws ConnettoreMdsException {
        log.debug("Categoria Flusso {} - path {}", categoriaFlusso, path.toString());

        if (CATEGORIA_FLUSSI_DIR.equals(categoriaFlusso)) {
            return NOME_FLUSSO_DIR;
        }
        if (CATEGORIA_FLUSSI_OSP.equals(categoriaFlusso)) {
            return NOME_FLUSSO_OSP;
        }else {
            log.error("Nome flusso per " + categoriaFlusso + " e file " + path + " non riconosciuto");
            throw new ConnettoreMdsException("Nome flusso per " + categoriaFlusso + " e file " + path + " non riconosciuto");
        }
    }

    private static String getNomeFlussoCnsCt2(String categoriaFlusso, String nomeFlusso, Path path) throws ConnettoreMdsException {
        log.debug("Categoria Flusso {} - path {}", categoriaFlusso, path.toString());

        if (CATEGORIA_FLUSSI_CNS_CT2.equals(categoriaFlusso)) {
            if (path.toString().contains(NOME_FLUSSO_CNS)) {
                return NOME_FLUSSO_CNS;
            } else if (path.toString().contains(NOME_FLUSSO_CT2)) {
                return NOME_FLUSSO_CT2;
            }
            else {
                log.error("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
                throw new ConnettoreMdsException("Nome flusso per " + categoriaFlusso + " e file " + path.toString() + " non riconosciuto");
            }
        }
        return nomeFlusso;
    }
}
