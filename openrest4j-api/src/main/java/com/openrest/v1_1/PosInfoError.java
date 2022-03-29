package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PosInfoError implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PosInfoError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public PosInfoError clone() {
        return new PosInfoError(code, message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosInfoError that = (PosInfoError) o;
        return Objects.equals(code, that.code) &&
               Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @JsonInclude(Include.NON_NULL)
    public String code;

    @JsonInclude(Include.NON_NULL)
    public String message;
}
