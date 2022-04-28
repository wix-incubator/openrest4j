package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PosInfoError implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PosInfoError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public PosInfoError(String code, String message, Map<String, String> params) {
        this.code = code;
        this.message = message;
        this.params = params;
    }


    @Override
    public PosInfoError clone() {
        return new PosInfoError(code, message, params);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosInfoError that = (PosInfoError) o;
        return Objects.equals(code, that.code) &&
               Objects.equals(message, that.message) &&
               Objects.equals(params, that.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, params);
    }

    @Override
    public String toString() {
        return "PosInfoError{" +
            "code='" + code + '\'' +
            ", message='" + message + '\'' +
            ", params='" + params + '\'' +
            '}';
    }


    @JsonInclude(Include.NON_NULL)
    public String code;

    @JsonInclude(Include.NON_NULL)
    public String message;

    @JsonInclude(Include.NON_NULL)
    public Map<String, String> params;
}
