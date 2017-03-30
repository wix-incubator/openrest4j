package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Billing;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetBillingRequest extends Request {
	public static final String TYPE = "set_billing";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetBillingRequest() {}
    
    public SetBillingRequest(String accessToken, Billing billing) {
    	this.accessToken = accessToken;
    	this.billing = billing;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Billing billing;
}
