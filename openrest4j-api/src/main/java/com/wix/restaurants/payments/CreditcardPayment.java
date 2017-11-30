package com.wix.restaurants.payments;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wix.pay.smaug.client.model.CreditCardToken;

import java.util.LinkedHashMap;
import java.util.Map;


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
                             String collectionMethod, CreditCardToken cardToken) {
        super(amount, externalIds);
        this.collectionMethod = collectionMethod;
        this.cardToken = cardToken;
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
                cardToken);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CreditcardPayment that = (CreditcardPayment) o;

        if (collectionMethod != null ? !collectionMethod.equals(that.collectionMethod) : that.collectionMethod != null)
            return false;
        return cardToken != null ? cardToken.equals(that.cardToken) : that.cardToken == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (collectionMethod != null ? collectionMethod.hashCode() : 0);
        result = 31 * result + (cardToken != null ? cardToken.hashCode() : 0);
        return result;
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
}
