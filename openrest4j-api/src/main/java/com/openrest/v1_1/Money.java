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

    public Money(Integer value, String formattedValue, String currency) {
        this.value = value;
        this.formattedValue = formattedValue;
        this.currency = currency;
    }

    @Override
    public Money clone() {
        return new Money(value, formattedValue, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;
        return Objects.equals(value, money.value) &&
               Objects.equals(formattedValue, money.formattedValue) &&
               Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, formattedValue, currency);
    }

    /** The value of money */
    @JsonInclude(Include.NON_NULL)
    public Integer value;

    /** The currency of money */
    @JsonInclude(Include.NON_NULL)
    public String currency;
    
    /** The formatted value of money */
    @JsonInclude(Include.NON_NULL)
    public String formattedValue;
}
