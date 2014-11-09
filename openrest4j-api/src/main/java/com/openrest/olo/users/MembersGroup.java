package com.openrest.olo.users;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.ClientId;

/** Group based on list of members. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembersGroup extends Group {
    public static final String TYPE = "members";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public MembersGroup() {}
    
    public MembersGroup(String id, Map<String, String> title, Map<String, String> description,
    		Boolean joinable, Map<String, String> properties) {
    	super(id, title, description, properties);
    	this.joinable = joinable;
    }
    
	@Override
	public Object clone() {
		return new MembersGroup(id,
			((title != null) ? new LinkedHashMap<String, String>(title) : null),
			((description != null) ? new LinkedHashMap<String, String>(description) : null),
			joinable,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean joinable = Boolean.FALSE;
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<ClientId> members = new LinkedList<ClientId>();
}