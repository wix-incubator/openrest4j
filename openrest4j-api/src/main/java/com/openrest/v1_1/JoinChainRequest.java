package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JoinChainRequest extends Request {
    public static final String TYPE = "join_chain";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public JoinChainRequest() {}

    public JoinChainRequest(String accessToken, String restaurantId, String chainId) {
        this.accessToken = accessToken;
        this.restaurantId = restaurantId;
        this.chainId = chainId;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String restaurantId;

    @JsonInclude(Include.NON_NULL)
    public String chainId;
}
