package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryAppsRequest extends Request {
    public static final String TYPE = "query_apps";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public QueryAppsRequest() {}
    
    public QueryAppsRequest(String accessToken, String ownerId) {
    	this.accessToken = accessToken;
    	this.ownerId = ownerId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String ownerId;
}
