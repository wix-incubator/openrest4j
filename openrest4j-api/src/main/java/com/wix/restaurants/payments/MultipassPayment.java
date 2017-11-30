package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Payment with MultiPass card.
 * @see <a href="http://multipass.co.il/">MultiPass</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipassPayment extends Payment {
    public static final String TYPE = "il.co.multipass";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public MultipassPayment() {}

    public MultipassPayment(Integer amount, Map<String, String> externalIds, String number, String pin) {
        super(amount, externalIds);
        this.number = number;
        this.pin = pin;
    }

    @Override
    public MultipassPayment clone() {
        return cloneImpl();
    }

    @Override
    protected MultipassPayment cloneImpl() {
        return new MultipassPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                number, pin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MultipassPayment that = (MultipassPayment) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return pin != null ? pin.equals(that.pin) : that.pin == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (pin != null ? pin.hashCode() : 0);
        return result;
    }

    /** MultiPass card number. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String number;

    /** MultiPass PIN. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String pin;
}
