package com.openrest.olo.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.CreditCard;

import java.util.Map;

/** Payment with a Bitcoin via Bits of Gold. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitsofgoldPayment extends Payment {
    public static final String TYPE = "il.co.bitsofgold";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public BitsofgoldPayment() {}

    public BitsofgoldPayment(Integer amount, Map<String, String> externalIds, CreditCard card, String token) {
        super(amount, externalIds);
        this.card = card;
        this.token = token;
    }

    @Override
    public Object clone() {
        return new BitsofgoldPayment(amount, externalIds, card, token);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final BitsofgoldPayment that = (BitsofgoldPayment) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (externalIds != null ? !externalIds.equals(that.externalIds) : that.externalIds != null) return false;
        if (card != null ? !card.equals(that.card) : that.card != null) return false;
        return !(token != null ? !token.equals(that.token) : that.token != null);

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        result = 31 * result + (card != null ? card.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    /** Credit card details (to be filled by BitsOfGold). */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CreditCard card;

    /** Payment token. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String token;
}
