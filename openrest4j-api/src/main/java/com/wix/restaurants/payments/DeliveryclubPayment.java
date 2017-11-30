package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
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
    public DeliveryclubPayment clone() {
        return cloneImpl();
    }

    @Override
    protected DeliveryclubPayment cloneImpl() {
        return new DeliveryclubPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null));
    }
}
