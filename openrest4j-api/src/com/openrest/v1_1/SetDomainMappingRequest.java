package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String domain;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
