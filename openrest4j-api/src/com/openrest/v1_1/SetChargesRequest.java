package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetChargesRequest extends Request {
	public static final String TYPE = "set_charges";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetChargesRequest() {}
    
    public SetChargesRequest(String accessToken, String organizationId, Charges charges) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.charges = charges;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Charges charges;
}
