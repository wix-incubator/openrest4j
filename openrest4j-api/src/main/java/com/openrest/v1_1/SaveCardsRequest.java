package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.pay.creditcard.tokenizer.model.CreditCardToken;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveCardsRequest extends Request {
    public static final String TYPE = "save_cards";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SaveCardsRequest() {}

    public SaveCardsRequest(String accessToken, ClientId clientId, List<CreditCardToken> cardTokens) {
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.cardTokens = cardTokens;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** User to save the card for (null means the authenticated user). */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;

    /** Temporary card tokens to save. */
    @JsonInclude(Include.NON_NULL)
    public List<CreditCardToken> cardTokens;
}
