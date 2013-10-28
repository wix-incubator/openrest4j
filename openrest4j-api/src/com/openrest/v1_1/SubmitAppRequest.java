package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitAppRequest extends Request {
    public static final String TYPE = "submit_app";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SubmitAppRequest() {}
    
    public SubmitAppRequest(String accessToken, AppBuildInfo appBuildInfo) {
    	this.accessToken = accessToken;
    	this.appBuildInfo = appBuildInfo;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public AppBuildInfo appBuildInfo;
}
