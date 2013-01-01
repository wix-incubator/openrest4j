package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRolesRequest extends Request {
	public static final String TYPE = "get_roles";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetRolesRequest() {}
    
    public GetRolesRequest(String accessToken, String userId) {
    	this.accessToken = accessToken;
    	this.userId = userId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String userId;
}
