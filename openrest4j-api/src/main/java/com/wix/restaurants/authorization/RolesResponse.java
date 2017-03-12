package com.wix.restaurants.authorization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.AcceptedDocument;
import com.wix.restaurants.authorization.Role;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class RolesResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public RolesResponse() {}
	
    public RolesResponse(String userId, List<Role> roles, List<AcceptedDocument> accepted) {
    	this.userId = userId;
    	this.roles = roles;
    	this.accepted = accepted;
    }
    
    @JsonInclude(Include.NON_NULL)
	public String userId;

    @JsonInclude(Include.NON_DEFAULT)
	public List<Role> roles = new LinkedList<>();
    
    /** Lists terms of service the user accepted. */
    @JsonInclude(Include.NON_DEFAULT)
	public List<AcceptedDocument> accepted = new LinkedList<>();
}
