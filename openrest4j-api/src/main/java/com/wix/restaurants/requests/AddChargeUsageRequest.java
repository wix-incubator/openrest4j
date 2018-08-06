package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.authentication.model.User;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddChargeUsageRequest extends Request {
	public static final String TYPE = "add_charge_usage";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AddChargeUsageRequest() {}
    
    public AddChargeUsageRequest(String accessToken, String organizationId, User clientId, Map<String, Integer> counts) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.clientId = clientId;
    	this.counts = counts;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public User clientId;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Integer> counts = new LinkedHashMap<>();
}
