package com.openrest.v1_1;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> fields;
}
