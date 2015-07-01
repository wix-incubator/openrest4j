package com.openrest.olo.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/** Payment in delivery-club.ru credit. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryclubPayment extends Payment {
    public static final String TYPE = "ru.delivery-club";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliveryclubPayment() {}

    public DeliveryclubPayment(Integer amount, Map<String, String> externalIds) {
        super(amount, externalIds);
    }

    @Override
    public Object clone() {
        return new DeliveryclubPayment(amount, externalIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final DeliveryclubPayment payment = (DeliveryclubPayment) o;

        if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;
        if (externalIds != null ? !externalIds.equals(payment.externalIds) : payment.externalIds != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        return result;
    }
}
