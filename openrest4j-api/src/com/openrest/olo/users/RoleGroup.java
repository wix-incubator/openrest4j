package com.openrest.olo.users;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Group based on having a role in an organiztion. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleGroup extends Group {
    public static final String TYPE = "role";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public RoleGroup() {}
    
    public RoleGroup(String id, Map<String, String> title, Map<String, String> description,
    		String organizationId, String role, Map<String, String> properties) {
    	super(id, title, description, properties);
    	this.organizationId = organizationId;
    	this.role = role;
    }
    
	@Override
	public Object clone() {
		return new RoleGroup(id,
			((title != null) ? new LinkedHashMap<String, String>(title) : null),
			((description != null) ? new LinkedHashMap<String, String>(description) : null),
			organizationId, role,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
	/** The organization's ID. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
	/** The role in the organization. */
    @JsonInclude(Include.NON_NULL)
    public String role;
}