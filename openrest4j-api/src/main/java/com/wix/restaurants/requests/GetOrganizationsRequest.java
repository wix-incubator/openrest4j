package com.wix.restaurants.requests;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrganizationsRequest extends Request {
	public static final String TYPE = "get_organizations";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrganizationsRequest() {}
    
    public GetOrganizationsRequest(String distributorId, String chainId, Set<String> restaurantIds,
    		Set<String> organizationTypes, Set<String> fields) {
    	this.distributorId = distributorId;
    	this.chainId = chainId;
    	this.restaurantIds = restaurantIds;
    	this.organizationTypes = organizationTypes;
    	this.fields = fields;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    @JsonInclude(Include.NON_NULL)
    public String chainId;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> restaurantIds;

    @JsonInclude(Include.NON_NULL)
    public Set<String> organizationTypes;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
