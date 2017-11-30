package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/** Cash on delivery. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashPayment extends Payment {
    public static final String TYPE = "cash";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CashPayment() {}

    public CashPayment(Integer amount, Map<String, String> externalIds) {
        super(amount, externalIds);
    }

    @Override
    public CashPayment clone() {
        return cloneImpl();
    }

    @Override
    protected CashPayment cloneImpl() {
        return new CashPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null));
    }
}
