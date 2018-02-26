package com.wix.restaurants.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

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
	public Role clone() {
    	return new Role(organizationId, organizationType, role);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(organizationId, role1.organizationId) &&
                Objects.equals(organizationType, role1.organizationType) &&
                Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, organizationType, role);
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
