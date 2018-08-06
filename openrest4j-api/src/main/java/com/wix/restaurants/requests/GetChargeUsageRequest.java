package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.authentication.model.User;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChargeUsageRequest extends Request {
	public static final String TYPE = "get_charge_usage";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetChargeUsageRequest() {}
    
    public GetChargeUsageRequest(String accessToken, User clientId, Set<String> chargeIds) {
    	this.accessToken = accessToken;
    	this.clientId = clientId;
    	this.chargeIds = chargeIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    /** User to query (null means "current user"). */
    @JsonInclude(Include.NON_NULL)
    public User clientId;
    
    /** Charges to query (null means "all"). */
    @JsonInclude(Include.NON_NULL)
    public Set<String> chargeIds;
}
