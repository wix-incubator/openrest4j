package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrganizationFullRequest extends Request {
	public static final String TYPE = "get_organization_full";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrganizationFullRequest() {}
    
    public GetOrganizationFullRequest(String organizationId) {
    	this.organizationId = organizationId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
