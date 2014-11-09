package com.openrest.v1_1;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddChargeUsageRequest extends Request {
	public static final String TYPE = "add_charge_usage";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AddChargeUsageRequest() {}
    
    public AddChargeUsageRequest(String accessToken, String organizationId, ClientId clientId, Map<String, Integer> counts) {
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
    public ClientId clientId;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Integer> counts = new LinkedHashMap<String, Integer>();
}
