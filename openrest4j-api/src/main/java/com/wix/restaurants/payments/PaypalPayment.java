package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/** PayPal. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaypalPayment extends Payment {
    public static final String TYPE = "paypal";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PaypalPayment() {}

    public PaypalPayment(Integer amount, Map<String, String> externalIds) {
        super(amount, externalIds);
    }

    @Override
    public PaypalPayment clone() {
        return cloneImpl();
    }

    @Override
    protected PaypalPayment cloneImpl() {
        return new PaypalPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null));
    }
}
