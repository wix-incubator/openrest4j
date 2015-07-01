package com.openrest.olo.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.CreditCard;
import com.wix.pay.creditcard.tokenizer.model.CreditCardToken;

import java.util.Map;

/** Payment with a credit/debit card. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditcardPayment extends Payment {
    public static final String TYPE = "credit";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CreditcardPayment() {}

    public CreditcardPayment(Integer amount, Map<String, String> externalIds, CreditCard card, CreditCardToken cardToken,
                             String userId, String id, String password) {
        super(amount, externalIds);
        this.card = card;
        this.cardToken = cardToken;
        this.userId = userId;
        this.id = id;
        this.password = password;
    }

    @Override
    public Object clone() {
        return new CreditcardPayment(amount, externalIds, card, cardToken, userId, id, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CreditcardPayment that = (CreditcardPayment) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (externalIds != null ? !externalIds.equals(that.externalIds) : that.externalIds != null) return false;
        if (card != null ? !card.equals(that.card) : that.card != null) return false;
        if (cardToken != null ? !cardToken.equals(that.cardToken) : that.cardToken != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(password != null ? !password.equals(that.password) : that.password != null);

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        result = 31 * result + (card != null ? card.hashCode() : 0);
        result = 31 * result + (cardToken != null ? cardToken.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    /** Credit card details (will be deprecated 2015-08-01). */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CreditCard card;

    /** Credit card details */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CreditCardToken cardToken;

    /** The user's Facebook id (for saved payments). */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String userId;

    /** Payment unique id (for saved payments). */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String id;

    /**
     * Optional user-defined password for protecting against unauthorized usage (for saved payments).
     *
     * For anonymized saved payments, this would either be missing (null) to indicate
     * no password, or empty ("") to indicate a password exists and was anonymized.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String password;
}
