package com.openrest.olo.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.CreditCard;
import com.wix.pay.creditcard.tokenizer.model.CreditCardToken;

import java.util.LinkedHashMap;
import java.util.Map;

/** Payment with a credit/debit card. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditcardPayment extends Payment {
    public static final String TYPE = "credit";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CreditcardPayment() {}

    public CreditcardPayment(Integer amount, Map<String, String> externalIds,
                             String collectionMethod, CreditCardToken cardToken,
                             CreditCard card) {
        super(amount, externalIds);
        this.collectionMethod = collectionMethod;
        this.cardToken = cardToken;
        this.card = card;
    }

    @Override
    public Object clone() {
        return new CreditcardPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                collectionMethod,
                cardToken,
                ((card != null) ? (CreditCard) card.clone() : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CreditcardPayment that = (CreditcardPayment) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (externalIds != null ? !externalIds.equals(that.externalIds) : that.externalIds != null) return false;
        if (collectionMethod != null ? !collectionMethod.equals(that.collectionMethod) : that.collectionMethod != null) return false;
        if (cardToken != null ? !cardToken.equals(that.cardToken) : that.cardToken != null) return false;
        return !(card != null ? !card.equals(that.card) : that.card != null);
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        result = 31 * result + (collectionMethod != null ? collectionMethod.hashCode() : 0);
        result = 31 * result + (cardToken != null ? cardToken.hashCode() : 0);
        result = 31 * result + (card != null ? card.hashCode() : 0);
        return result;
    }

    /**
     * Credit card collection method.
     * @see com.openrest.v1_1.CreditcardsInfo#ALL_COLLECTION_METHODS
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String collectionMethod;

    /** Card token (if card is collected online). */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CreditCardToken cardToken;

    /** Credit card details (will be deprecated 2015-08-01). */
    @Deprecated
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CreditCard card;
}
