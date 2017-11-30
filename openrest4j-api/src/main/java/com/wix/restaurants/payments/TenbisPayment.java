package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Payment by 10bis card.
 * @see <a href="http://www.10bis.co.il/">10bis</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TenbisPayment extends Payment {
    public static final String TYPE = "10bis";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public TenbisPayment() {}

    public TenbisPayment(Integer amount, Map<String, String> externalIds, String number) {
        super(amount, externalIds);
        this.number = number;
    }

    @Override
    public TenbisPayment clone() {
        return cloneImpl();
    }

    @Override
    protected TenbisPayment cloneImpl() {
        return new TenbisPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TenbisPayment that = (TenbisPayment) o;

        return number != null ? number.equals(that.number) : that.number == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    /** 10bis card number. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String number;
}
