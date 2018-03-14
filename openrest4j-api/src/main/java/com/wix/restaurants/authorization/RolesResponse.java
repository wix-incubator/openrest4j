package com.wix.restaurants.authorization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.AcceptedDocument;
import com.wix.restaurants.authorization.Role;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class RolesResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public RolesResponse() {}
	
    public RolesResponse(String userId, List<Role> roles, List<AcceptedDocument> accepted) {
    	this.userId = userId;
    	this.roles = roles;
    	this.accepted = accepted;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RolesResponse that = (RolesResponse) o;
		return Objects.equals(userId, that.userId) &&
				Objects.equals(roles, that.roles) &&
				Objects.equals(accepted, that.accepted);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, roles, accepted);
	}

	@Override
	public String toString() {
		return "RolesResponse{" +
				"userId='" + userId + '\'' +
				", roles=" + roles +
				", accepted=" + accepted +
				'}';
	}

    @JsonInclude(Include.NON_NULL)
	public String userId;

    @JsonInclude(Include.NON_DEFAULT)
	public List<Role> roles = new LinkedList<>();
    
    /** Lists terms of service the user accepted. */
    @JsonInclude(Include.NON_DEFAULT)
	public List<AcceptedDocument> accepted = new LinkedList<>();
}
