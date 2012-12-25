package com.openrest.v1_1;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String restaurantId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> fields;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer limit;
    
    /** Omit porals with these ids from the results (ignored if null). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> excludeIds;
}
