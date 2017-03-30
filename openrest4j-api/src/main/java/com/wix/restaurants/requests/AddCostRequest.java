package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Cost;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddCostRequest extends Request {
	public static final String TYPE = "add_cost";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AddCostRequest() {}
    
    public AddCostRequest(String accessToken, String organizationId, Cost cost) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.cost = cost;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Cost cost;
}
