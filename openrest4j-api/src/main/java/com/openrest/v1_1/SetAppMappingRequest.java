package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetAppMappingRequest extends Request {
	public static final String TYPE = "set_app_mapping";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetAppMappingRequest() {}
    
    public SetAppMappingRequest(String accessToken, AppId appId, String organizationId) {
    	this.accessToken = accessToken;
    	this.appId = appId;
    	this.organizationId = organizationId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public AppId appId;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
