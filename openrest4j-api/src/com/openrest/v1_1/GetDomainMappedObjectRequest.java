package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Deprecated 2014-02-27, use GetAppMappedObjectRequest (platform=web, id=domain, version=any) */
@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDomainMappedObjectRequest extends Request {
	public static final String TYPE = "get_domain_mapped_object";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetDomainMappedObjectRequest() {}
    
    public GetDomainMappedObjectRequest(String domain) {
    	this.domain = domain;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String domain;
}
