package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public AppId appId;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
}
