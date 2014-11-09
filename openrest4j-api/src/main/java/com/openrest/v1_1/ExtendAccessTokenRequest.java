package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtendAccessTokenRequest extends Request {
	public static final String TYPE = "extend";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public ExtendAccessTokenRequest() {}
    
    public ExtendAccessTokenRequest(String accessToken, String fbAppId) {
    	this.accessToken = accessToken;
    	this.fbAppId = fbAppId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String fbAppId;
}
