package com.wix.restaurants.requests;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.AppId;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAppMappedObjectRequest extends Request {
	public static final String TYPE = "get_app_mapped_object";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetAppMappedObjectRequest() {}
    
    public GetAppMappedObjectRequest(AppId appId, Boolean full, Set<String> fields) {
    	this.appId = appId;
    	this.full = full;
    	this.fields = fields;
    }
    
    @JsonInclude(Include.NON_NULL)
    public AppId appId;
    
    /** Whether or not the "full" organization object is requested. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean full = Boolean.TRUE;

    /** If full=false */
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
