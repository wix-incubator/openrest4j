package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChargeUsageRequest extends Request {
	public static final String TYPE = "get_charge_usage";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetChargeUsageRequest() {}
    
    public GetChargeUsageRequest(String accessToken, ClientId clientId, Set<String> chargeIds) {
    	this.accessToken = accessToken;
    	this.clientId = clientId;
    	this.chargeIds = chargeIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    /** User to query (null means "current user"). */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;
    
    /** Charges to query (null means "all"). */
    @JsonInclude(Include.NON_NULL)
    public Set<String> chargeIds;
}
