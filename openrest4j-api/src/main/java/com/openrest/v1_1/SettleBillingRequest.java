package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SettleBillingRequest extends Request {
	public static final String TYPE = "settle_billing";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SettleBillingRequest() {}
    
    public SettleBillingRequest(String accessToken, String supplierId) {
    	this.accessToken = accessToken;
    	this.supplierId = supplierId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String supplierId;
}
