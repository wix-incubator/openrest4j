package com.openrest.v1_1;

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
    
    public GetOrganizationsRequest(String distributorId, Set<String> fields) {
    	this.distributorId = distributorId;
    	this.fields = fields;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String distributorId;

    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
