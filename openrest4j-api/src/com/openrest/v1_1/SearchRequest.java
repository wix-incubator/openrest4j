package com.openrest.v1_1;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String distributorId;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String chainId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public LatLng latLng;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> states;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> features;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String query;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> chargeTypes;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> fields;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer limit;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> excludeIds;
}
