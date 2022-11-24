package com.wix.restaurants.fees;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

public class Amount extends Value implements Serializable, Cloneable {
    public static final String TYPE = "Amount";
    private static final long serialVersionUID = 1L;

    public Amount() {}

    public Amount(String value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public Amount clone() {
        return new Amount(value, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Amount that = (Amount) o;
        return Objects.equals(value, that.value) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value, currency);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String currency;
}
