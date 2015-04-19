package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticateRequest extends Request {
    public static final String TYPE = "authenticate";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public AuthenticateRequest() {}

    public AuthenticateRequest(Credentials credentials) {
        this.credentials = credentials;
    }

    @JsonInclude(Include.NON_NULL)
    public Credentials credentials;
}
