package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.pay.creditcard.tokenizer.model.CreditCardToken;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteCardRequest extends Request {
    public static final String TYPE = "delete_card";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeleteCardRequest() {}

    public DeleteCardRequest(String accessToken, ClientId clientId, CreditCardToken cardToken) {
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.cardToken = cardToken;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** User to delete the card for (null means the authenticated user). */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;

    /** Permanent card token to delete. */
    @JsonInclude(Include.NON_NULL)
    public CreditCardToken cardToken;
}
