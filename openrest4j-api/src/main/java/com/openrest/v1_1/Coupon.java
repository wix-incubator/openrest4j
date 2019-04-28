package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coupon implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Coupon() {}

    public Coupon(String code, String token) {
        this.code = code;
        this.token = token;
    }

    @Override
	public Coupon clone() {
    	return new Coupon(code, token);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coupon that = (Coupon) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    /** The charge id. */
    @JsonInclude(Include.NON_NULL)
    public String code;

    /** The amount. */
    @JsonInclude(Include.NON_NULL)
    public String token;
}
