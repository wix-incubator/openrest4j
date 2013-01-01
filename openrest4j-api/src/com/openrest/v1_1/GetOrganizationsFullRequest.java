package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrganizationsFullRequest extends Request {
	public static final String TYPE = "get_organizations_full";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrganizationsFullRequest() {}
    
    public GetOrganizationsFullRequest(Long modifiedAfter, Integer limit) {
    	this.modifiedAfter = modifiedAfter;
    	this.limit = limit;
    }
    
    @JsonInclude(Include.NON_NULL)
    public Long modifiedAfter;
    
    @JsonInclude(Include.NON_NULL)
    public Integer limit;
}
