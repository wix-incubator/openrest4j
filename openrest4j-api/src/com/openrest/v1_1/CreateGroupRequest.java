package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.users.Group;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateGroupRequest extends Request {
	public static final String TYPE = "create_group";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CreateGroupRequest() {}
    
    public CreateGroupRequest(String accessToken, Group group) {
    	this.accessToken = accessToken;
    	this.group = group;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Group group;
}
