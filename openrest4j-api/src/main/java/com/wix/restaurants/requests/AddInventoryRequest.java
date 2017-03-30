package com.wix.restaurants.requests;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddInventoryRequest extends Request {
	public static final String TYPE = "add_inventory";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AddInventoryRequest() {}
    
    public AddInventoryRequest(String accessToken, String organizationId, Map<String, Integer> counts) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.counts = counts;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Integer> counts = new LinkedHashMap<>();
}
