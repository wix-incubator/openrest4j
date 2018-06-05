package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** PayPal. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CibusPayment extends Payment {
    public static final String TYPE = "il.co.mysodexo";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CibusPayment() {}

    public CibusPayment(Integer amount, Map<String, String> externalIds, CibusCard card) {
        super(amount, externalIds);
        this.card = card;
    }

    @Override
    public CibusPayment clone() {
        return cloneImpl();
    }

    @Override
    protected CibusPayment cloneImpl() {
        return new CibusPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null), card);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CibusPayment that = (CibusPayment) o;
        return Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), card);
    }

    /** Payment token. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CibusCard card;
}
