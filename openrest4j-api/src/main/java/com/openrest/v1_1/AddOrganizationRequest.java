package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddOrganizationRequest extends Request {
	public static final String TYPE = "add_organization";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AddOrganizationRequest() {}
    
    public AddOrganizationRequest(String accessToken, Organization organization) {
    	this.accessToken = accessToken;
    	this.organization = organization;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Organization organization;
}
