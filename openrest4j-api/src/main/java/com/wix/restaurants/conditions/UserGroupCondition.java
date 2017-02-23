package com.wix.restaurants.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
	public Object clone() {
		return new UserGroupCondition(groupId,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public String groupId;
}