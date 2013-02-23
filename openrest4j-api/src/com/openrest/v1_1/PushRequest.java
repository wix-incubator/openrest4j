package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PushRequest extends Request {
    public static final String TYPE = "push";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public PushRequest() {}
    
    public PushRequest(String accessToken, AppId appId, Push push) {
    	this.accessToken = accessToken;
    	this.appId = appId;
    	this.push = push;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public AppId appId;
    
    @JsonInclude(Include.NON_NULL)
    public Push push;
}
