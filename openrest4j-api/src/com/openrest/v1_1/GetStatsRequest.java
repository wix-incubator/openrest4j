package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetStatsRequest extends Request {
	public static final String TYPE = "get_stats";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetStatsRequest() {}
    
    public GetStatsRequest(String accessToken, String distributorId, String chainId, Set<String> restaurantIds,
    		Date since, Date until, String granularity, String ref) {
    	this.accessToken = accessToken;
    	this.distributorId = distributorId;
    	this.chainId = chainId;
    	this.restaurantIds = restaurantIds;
    	this.since = since;
    	this.until = until;
    	this.granularity = granularity;
    	this.ref = ref;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    @JsonInclude(Include.NON_NULL)
    public String chainId;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> restaurantIds;
    
    @JsonInclude(Include.NON_NULL)
    public Date since;

    @JsonInclude(Include.NON_NULL)
    public Date until;
    
    @JsonInclude(Include.NON_NULL)
    public String granularity;
    
    @JsonInclude(Include.NON_NULL)
    public String ref;
}
