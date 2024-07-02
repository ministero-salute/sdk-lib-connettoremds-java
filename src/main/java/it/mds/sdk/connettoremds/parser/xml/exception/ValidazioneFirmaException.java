/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.parser.xml.exception;

public class ValidazioneFirmaException extends Exception {

    public ValidazioneFirmaException() {
        super();
    }

    public ValidazioneFirmaException(String message) {
        super(message);
    }

    public ValidazioneFirmaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidazioneFirmaException(Throwable cause) {
        super(cause);
    }

    protected ValidazioneFirmaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
