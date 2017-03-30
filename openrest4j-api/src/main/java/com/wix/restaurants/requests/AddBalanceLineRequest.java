package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.BalanceLine;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddBalanceLineRequest extends Request {
    public static final String TYPE = "add_balance_line";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AddBalanceLineRequest() {}
    
    public AddBalanceLineRequest(String accessToken, BalanceLine line) {
    	this.accessToken = accessToken;
    	this.line = line;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public BalanceLine line;
}
