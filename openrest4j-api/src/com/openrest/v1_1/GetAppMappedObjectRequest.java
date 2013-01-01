package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAppMappedObjectRequest extends Request {
	public static final String TYPE = "get_app_mapped_object";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetAppMappedObjectRequest() {}
    
    public GetAppMappedObjectRequest(AppId appId) {
    	this.appId = appId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public AppId appId;
}
