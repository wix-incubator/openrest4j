package com.openrest.v1_1;

public class OpenrestException extends Exception {
	public OpenrestException(String error, String errorMessage) {
        super(error + "|" + errorMessage);
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public OpenrestException(String error, String errorMessage, Throwable cause) {
        super(error + "|" + errorMessage, cause);
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public String error() {
        return error;
    }

    public String errorMessage() {
        return errorMessage;
    }

    private final String error;
    private final String errorMessage;
    
	private static final long serialVersionUID = 1L;
}
