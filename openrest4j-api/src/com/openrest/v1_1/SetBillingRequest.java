package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetBillingRequest extends Request {
	public static final String TYPE = "set_billing";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetBillingRequest() {}
    
    public SetBillingRequest(String accessToken, String organizationId, Billing billing) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.billing = billing;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Billing billing;
}
