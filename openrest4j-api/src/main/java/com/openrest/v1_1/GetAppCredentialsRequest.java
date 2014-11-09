package com.openrest.v1_1;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAppCredentialsRequest extends Request {
    public static final String TYPE = "get_app_credentials";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetAppCredentialsRequest() {}
    
    public GetAppCredentialsRequest(String accessToken, List<AppId> appIds) {
    	this.accessToken = accessToken;
    	this.appIds = appIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<AppId> appIds = new LinkedList<AppId>();
}
