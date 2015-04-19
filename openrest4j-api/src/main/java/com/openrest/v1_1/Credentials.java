package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

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
    public Object clone() {
        return new Credentials(username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credentials that = (Credentials) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return !(password != null ? !password.equals(that.password) : that.password != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    /** The username. */
    @JsonInclude(Include.NON_NULL)
    public String username;

    /** The password. */
    @JsonInclude(Include.NON_NULL)
    public String password;
}
