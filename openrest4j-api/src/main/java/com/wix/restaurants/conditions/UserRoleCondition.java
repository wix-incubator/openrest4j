package com.wix.restaurants.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Satisfied if a user has a given role in a given organization. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRoleCondition extends Condition {
    public static final String TYPE = "user_role";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public UserRoleCondition() {}
    
    public UserRoleCondition(String organizationId, String role, Map<String, String> properties) {
    	super(properties);
    	this.organizationId = organizationId;
    	this.role = role;
    }

    @Override
    public UserRoleCondition clone() {
        return cloneImpl();
    }

    @Override
    protected UserRoleCondition cloneImpl() {
        return new UserRoleCondition(organizationId, role,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserRoleCondition that = (UserRoleCondition) o;

        if (organizationId != null ? !organizationId.equals(that.organizationId) : that.organizationId != null) return false;
        return role != null ? role.equals(that.role) : that.role == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public String role;
}