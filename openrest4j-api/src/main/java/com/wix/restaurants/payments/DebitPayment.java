package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/** Payment with Debit card (deprecated, use CreditcardPayment). */
@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebitPayment extends Payment {
    public static final String TYPE = "debit";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DebitPayment() {}

    public DebitPayment(Integer amount, Map<String, String> externalIds) {
        super(amount, externalIds);
    }

    @Override
    public DebitPayment clone() {
        return cloneImpl();
    }

    @Override
    protected DebitPayment cloneImpl() {
        return new DebitPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null));
    }
}
