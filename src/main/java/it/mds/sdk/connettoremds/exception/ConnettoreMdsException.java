package it.mds.sdk.connettoremds.exception;

public class ConnettoreMdsException extends Exception{

    public ConnettoreMdsException() {
        super();
    }

    public ConnettoreMdsException(String message) {
        super(message);
    }

    public ConnettoreMdsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnettoreMdsException(Throwable cause) {
        super(cause);
    }

    protected ConnettoreMdsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
