package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String userId;
}
