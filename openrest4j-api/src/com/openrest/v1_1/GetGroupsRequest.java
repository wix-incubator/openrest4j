package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetGroupsRequest extends Request {
	public static final String TYPE = "get_groups";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetGroupsRequest() {}
    
    public GetGroupsRequest(String accessToken, Set<String> groupIds) {
    	this.accessToken = accessToken;
    	this.groupIds = groupIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> groupIds;
}
