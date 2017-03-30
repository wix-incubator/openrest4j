package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.ClientId;
import com.wix.pay.creditcard.tokenizer.model.CreditCardToken;

/**
 * Deprecated on 2016-09-14.
 * Use SaveCardsRequest
 */
@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveCardRequest extends Request {
    public static final String TYPE = "save_card";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SaveCardRequest() {}

    public SaveCardRequest(String accessToken, ClientId clientId, CreditCardToken cardToken) {
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.cardToken = cardToken;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** User to save the card for (null means the authenticated user). */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;

    /** Temporary card token to save. */
    @JsonInclude(Include.NON_NULL)
    public CreditCardToken cardToken;
}
