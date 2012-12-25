package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class RolesResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public RolesResponse() {}
	
    public RolesResponse(String userId, List<Role> roles) {
    	this.userId = userId;
    	this.roles = roles;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public String userId;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public List<Role> roles = new ArrayList<Role>();
}
