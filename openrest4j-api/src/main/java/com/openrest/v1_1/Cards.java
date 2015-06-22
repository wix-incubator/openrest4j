package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.pay.creditcard.tokenizer.model.CreditCardToken;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Cards implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Cards() {}

    public Cards(List<CreditCardToken> cardTokens) {
        this.cardTokens = cardTokens;
    }

    @JsonInclude(Include.NON_NULL)
    public List<CreditCardToken> cardTokens = new LinkedList<>();
}
