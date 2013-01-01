package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchRequest extends Request {
	public static final String TYPE = "search";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SearchRequest() {}
    
    public SearchRequest(String distributorId, String chainId, LatLng latLng, Set<String> states, Set<String> features, String query,
    		Set<String> chargeTypes, Set<String> fields, Integer limit, Set<String> excludeIds) {
    	this.distributorId = distributorId;
    	this.chainId = chainId;
    	this.latLng = latLng;
    	this.states = states;
    	this.features = features;
    	this.query = query;
    	this.chargeTypes = chargeTypes;
    	this.fields = fields;
    	this.limit = limit;
    	this.excludeIds = excludeIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String distributorId;

    @JsonInclude(Include.NON_NULL)
    public String chainId;
    
    @JsonInclude(Include.NON_NULL)
    public LatLng latLng;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> states;

    @JsonInclude(Include.NON_NULL)
    public Set<String> features;
    
    @JsonInclude(Include.NON_NULL)
    public String query;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> chargeTypes;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
    
    @JsonInclude(Include.NON_NULL)
    public Integer limit;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> excludeIds;
}
