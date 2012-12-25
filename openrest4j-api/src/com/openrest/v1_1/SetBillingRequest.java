package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Billing billing;
}
