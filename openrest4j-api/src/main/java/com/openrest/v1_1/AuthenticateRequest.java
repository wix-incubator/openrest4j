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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthenticateRequest that = (AuthenticateRequest) o;

        return credentials != null ? credentials.equals(that.credentials) : that.credentials == null;

    }

    @Override
    public int hashCode() {
        return credentials != null ? credentials.hashCode() : 0;
    }

    @JsonInclude(Include.NON_NULL)
    public Credentials credentials;
}
