package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Long modifiedAfter;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer limit;
}
