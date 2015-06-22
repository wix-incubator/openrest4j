package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCardsRequest extends Request {
    public static final String TYPE = "get_cards";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public GetCardsRequest() {}

    public GetCardsRequest(String accessToken, ClientId clientId) {
        this.accessToken = accessToken;
        this.clientId = clientId;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** User to retrieve the cards for (null means the authenticated user) */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;
}
