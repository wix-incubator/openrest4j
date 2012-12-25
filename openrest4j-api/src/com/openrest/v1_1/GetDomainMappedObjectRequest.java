package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDomainMappedObjectRequest extends Request {
	public static final String TYPE = "get_domain_mapped_object";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetDomainMappedObjectRequest() {}
    
    public GetDomainMappedObjectRequest(String domain) {
    	this.domain = domain;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String domain;
}
