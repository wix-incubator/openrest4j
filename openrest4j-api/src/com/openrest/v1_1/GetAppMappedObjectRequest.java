package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAppMappedObjectRequest extends Request {
	public static final String TYPE = "get_app_mapped_object";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetAppMappedObjectRequest() {}
    
    public GetAppMappedObjectRequest(AppId appId) {
    	this.appId = appId;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public AppId appId;
}
