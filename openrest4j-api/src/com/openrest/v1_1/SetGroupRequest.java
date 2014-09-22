package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.users.Group;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetGroupRequest extends Request {
	public static final String TYPE = "set_group";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetGroupRequest() {}
    
    public SetGroupRequest(String accessToken, Group group) {
    	this.accessToken = accessToken;
    	this.group = group;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Group group;
}
