package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Date;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetStatsRequest extends Request {
	public static final String TYPE = "get_stats";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetStatsRequest() {}
    
    public GetStatsRequest(String accessToken, String distributorId, String chainId, Set<String> restaurantIds,
    		String timezone, Date since, Date until, String granularity, String source, String platform, String ref) {
    	this.accessToken = accessToken;
    	this.distributorId = distributorId;
    	this.chainId = chainId;
    	this.restaurantIds = restaurantIds;
        this.timezone = timezone;
    	this.since = since;
    	this.until = until;
    	this.granularity = granularity;
    	this.source = source;
    	this.platform = platform;
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
    public String timezone;

    @JsonInclude(Include.NON_NULL)
    public Date since;

    @JsonInclude(Include.NON_NULL)
    public Date until;

    /** @see com.wix.restaurants.Granularities */
    @JsonInclude(Include.NON_NULL)
    public String granularity;
    
    @JsonInclude(Include.NON_NULL)
    public String source;

    @JsonInclude(Include.NON_NULL)
    public String platform;
    
    /** Use source and platform */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public String ref;
}
