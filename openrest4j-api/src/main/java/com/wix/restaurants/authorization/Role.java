package com.wix.restaurants.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Role(String organizationId, String organizationType, String role) {
    	this.organizationId = organizationId;
    	this.organizationType = organizationType;
    	this.role = role;
    }
    
    /** Default constructor for JSON deserialization. */
    public Role() {}
    
    @Override
	public Object clone() {
    	return new Role(organizationId, organizationType, role);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (organizationId != null ? !organizationId.equals(role1.organizationId) : role1.organizationId != null) return false;
        if (organizationType != null ? !organizationType.equals(role1.organizationType) : role1.organizationType != null) return false;
        return role != null ? role.equals(role1.role) : role1.role == null;
    }

    @Override
    public int hashCode() {
        int result = organizationId != null ? organizationId.hashCode() : 0;
        result = 31 * result + (organizationType != null ? organizationType.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "organizationId='" + organizationId + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    /** The organization id. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    /** The organization type, e.g. "restaurant", "chain", "portal", "distributor". */
    @JsonInclude(Include.NON_NULL)
    public String organizationType;
    
    /** @see Roles */
    @JsonInclude(Include.NON_NULL)
    public String role;
}
