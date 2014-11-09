package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetGroupStaffRequest extends Request {
	public static final String TYPE = "get_group_staff";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetGroupStaffRequest() {}
    
    public GetGroupStaffRequest(String accessToken, String groupId) {
    	this.accessToken = accessToken;
    	this.groupId = groupId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String groupId;
}
