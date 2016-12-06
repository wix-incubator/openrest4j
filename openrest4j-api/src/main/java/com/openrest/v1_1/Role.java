package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Role(String organizationId, String organizationType, String role) {
    	this.organizationId = organizationId;
    	this.organizationType = organizationType;
    	this.role = role;
    }
    
    /** Default constructor for JSON deserialization. */
    public Role() {}
    
    @Override
	public Object clone() {
    	return new Role(organizationId, organizationType, role);
	}
    
    /** The organization id. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    /** The organization type, e.g. "restaurant", "chain", "portal", "distributor". */
    @JsonInclude(Include.NON_NULL)
    public String organizationType;
    
    /** @see com.wix.restaurants.Roles */
    @JsonInclude(Include.NON_NULL)
    public String role;
}
