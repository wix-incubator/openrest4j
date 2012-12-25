package com.openrest.v1_1;

import java.io.IOException;

/**
 * An exception thrown by a RESTful HTTP server, with an optional returned value.
 * @author DL
 */
public class RestJsonHttpException extends IOException {
	public RestJsonHttpException(int httpErrorCode, Object value) {
        this.httpErrorCode = httpErrorCode;
        this.value = value;
    }

    public int httpErrorCode() {
        return httpErrorCode;
    }
    
    public Object value() {
        return value;
    }

    private final int httpErrorCode;
    private final Object value;
    
	private static final long serialVersionUID = 1L;
}
