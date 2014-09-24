package com.openrest.olo.charges.conditions;

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
	public Object clone() {
		return new UserRoleCondition(organizationId, role,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public String role;
}