package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.AppCredentials;
import com.openrest.v1_1.AppId;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetAppCredentialsRequest extends Request {
    public static final String TYPE = "set_app_credentials";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetAppCredentialsRequest() {}
    
    public SetAppCredentialsRequest(String accessToken, AppId appId, AppCredentials credentials) {
    	this.accessToken = accessToken;
    	this.appId = appId;
    	this.credentials = credentials;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public AppId appId;
    
    @JsonInclude(Include.NON_NULL)
    public AppCredentials credentials;
}
