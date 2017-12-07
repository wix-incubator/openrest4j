package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.Map;

/** Satisfied if a user is a member of a given group. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupCondition extends Condition {
    public static final String TYPE = "user_group";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public UserGroupCondition() {}
    
    public UserGroupCondition(String groupId, Map<String, String> properties) {
    	super(properties);
    	this.groupId = groupId;
    }

    @Override
    public UserGroupCondition clone() {
        return cloneImpl();
    }

    @Override
    protected UserGroupCondition cloneImpl() {
        return new UserGroupCondition(groupId,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserGroupCondition that = (UserGroupCondition) o;

        return groupId != null ? groupId.equals(that.groupId) : that.groupId == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public String groupId;
}