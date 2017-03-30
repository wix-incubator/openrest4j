package com.wix.restaurants.requests;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPortalsRequest extends Request {
	public static final String TYPE = "search_portals";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SearchPortalsRequest() {}
    
    public SearchPortalsRequest(String restaurantId, Set<String> fields, Integer limit, Set<String> excludeIds) {
    	this.restaurantId = restaurantId;
    	this.fields = fields;
    	this.limit = limit;
    	this.excludeIds = excludeIds;
    }
    
    /** Filter results to portals that include this restaurant (ignored if null). */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
    
    @JsonInclude(Include.NON_NULL)
    public Integer limit;
    
    /** Omit porals with these ids from the results (ignored if null). */
    @JsonInclude(Include.NON_NULL)
    public Set<String> excludeIds;
}
