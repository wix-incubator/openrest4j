package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Filter;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchRequest extends Request {
	public static final String TYPE = "search";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SearchRequest() {}
    
    public SearchRequest(Filter filter, Set<String> features, String query,
                         Set<String> fields, Integer limit, Set<String> excludeIds) {
    	this.filter = filter;
    	this.features = features;
    	this.query = query;
    	this.fields = fields;
    	this.limit = limit;
    	this.excludeIds = excludeIds;
    }
    
    @JsonInclude(Include.NON_DEFAULT)
    public Filter filter = new Filter();
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> features;
    
    @JsonInclude(Include.NON_NULL)
    public String query;

    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
    
    @JsonInclude(Include.NON_NULL)
    public Integer limit;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> excludeIds;
}
