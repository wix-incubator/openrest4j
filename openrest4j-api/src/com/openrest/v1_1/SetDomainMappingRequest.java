package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetDomainMappingRequest extends Request {
	public static final String TYPE = "set_domain_mapping";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetDomainMappingRequest() {}
    
    public SetDomainMappingRequest(String accessToken, String domain, String organizationId) {
    	this.accessToken = accessToken;
    	this.domain = domain;
    	this.organizationId = organizationId;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String domain;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
}
