package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Credentials implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** Default constructor for JSON deserialization. */
    public Credentials() {}

    @Override
    public Credentials clone() {
        return new Credentials(username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    /** The username. */
    @JsonInclude(Include.NON_NULL)
    public String username;

    /** The password. */
    @JsonInclude(Include.NON_NULL)
    public String password;
}
