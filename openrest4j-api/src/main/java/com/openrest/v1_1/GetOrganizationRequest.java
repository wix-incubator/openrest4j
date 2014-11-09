package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrganizationRequest extends Request {
    public static final String TYPE = "get_organization";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrganizationRequest() {}
    
    public GetOrganizationRequest(String organizationId, Set<String> fields) {
    	this.organizationId = organizationId;
    	this.fields = fields;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
