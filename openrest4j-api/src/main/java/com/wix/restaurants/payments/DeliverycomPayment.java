package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/** Payment in delivery.com credit. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliverycomPayment extends Payment {
    public static final String TYPE = "com.delivery";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliverycomPayment() {}

    public DeliverycomPayment(Integer amount, Map<String, String> externalIds) {
        super(amount, externalIds);
    }

    @Override
    public DeliverycomPayment clone() {
        return cloneImpl();
    }

    @Override
    protected DeliverycomPayment cloneImpl() {
        return new DeliverycomPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null));
    }
}
