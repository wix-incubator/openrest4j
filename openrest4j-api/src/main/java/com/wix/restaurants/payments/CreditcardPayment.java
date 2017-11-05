package com.wix.restaurants.payments;


import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wix.pay.smaug.client.model.CreditCardToken;


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
    public Object clone() {
        return new CreditcardPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                collectionMethod,
                cardToken);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CreditcardPayment that = (CreditcardPayment) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (externalIds != null ? !externalIds.equals(that.externalIds) : that.externalIds != null) return false;
        if (collectionMethod != null ? !collectionMethod.equals(that.collectionMethod) : that.collectionMethod != null) return false;
        return !(cardToken != null ? !cardToken.equals(that.cardToken) : that.cardToken != null);
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
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
