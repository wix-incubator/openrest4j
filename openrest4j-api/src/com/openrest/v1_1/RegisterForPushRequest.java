package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterForPushRequest extends Request {
    public static final String TYPE = "register_push";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public RegisterForPushRequest() {}
    
    public RegisterForPushRequest(String accessToken, AppId appId, String deviceToken) {
    	this.accessToken = accessToken;
    	this.appId = appId;
    	this.deviceToken = deviceToken;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public AppId appId;
    
    @JsonInclude(Include.NON_NULL)
    public String deviceToken;
}
