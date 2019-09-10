package com.wix.restaurants.payments;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wix.pay.smaug.client.model.CreditCardToken;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Payment with a credit/debit card.
 * @see <a href="https://en.wikipedia.org/wiki/Payment_card">Payment card</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditcardPayment extends Payment {
    public static final String TYPE = "credit";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CreditcardPayment() {}

    public CreditcardPayment(Integer amount, Map<String, String> externalIds,
                             String collectionMethod, CreditCardToken cardToken, String nonce) {
        super(amount, externalIds);
        this.collectionMethod = collectionMethod;
        this.cardToken = cardToken;
        this.nonce = nonce;
    }

    @Override
    public CreditcardPayment clone() {
        return cloneImpl();
    }

    @Override
    protected CreditcardPayment cloneImpl() {
        return new CreditcardPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                collectionMethod,
                cardToken,
                nonce);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditcardPayment that = (CreditcardPayment) o;
        return Objects.equals(collectionMethod, that.collectionMethod) &&
                Objects.equals(cardToken, that.cardToken) &&
                Objects.equals(nonce, that.nonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), collectionMethod, cardToken, nonce);
    }

    /**
     * Card collection method.
     * @see com.wix.restaurants.CollectionMethods
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String collectionMethod;

    /** Card token (if card is collected online). */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CreditCardToken cardToken;

    /** The nonce input parameter for the braintree gateway to use when additional 3ds2 authentication is required. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String nonce;
}
