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
    public Object clone() {
        return new TenbisPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final TenbisPayment that = (TenbisPayment) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (externalIds != null ? !externalIds.equals(that.externalIds) : that.externalIds != null) return false;
        return !(number != null ? !number.equals(that.number) : that.number != null);
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    /** 10bis card number. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String number;
}
