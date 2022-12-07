package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Money implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Money() {}

    public Money(String value, String formatted_value, String currency) {
        this.value = value;
        this.formatted_value = formatted_value;
        this.currency = currency;
    }

    @Override
    public Money clone() {
        return new Money(value, formatted_value, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;
        return Objects.equals(value, money.value) &&
               Objects.equals(formatted_value, money.formatted_value) &&
               Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, formatted_value, currency);
    }

    /** The value of money */
    @JsonInclude(Include.NON_NULL)
    public String value;

    /** The currency of money */
    @JsonInclude(Include.NON_NULL)
    public String currency;
    
    /** The formatted value of money */
    @JsonInclude(Include.NON_NULL)
    public String formatted_value;
}
