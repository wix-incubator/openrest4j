package com.openrest.olo.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.authentication.model.User;
import com.wix.restaurants.i18n.LocalizedString;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** Group based on list of members. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembersGroup extends Group {
    public static final String TYPE = "members";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public MembersGroup() {}
    
    public MembersGroup(String id, LocalizedString title, LocalizedString description,
						Boolean joinable, Map<String, String> properties) {
    	super(id, title, description, properties);
    	this.joinable = joinable;
    }
    
	@Override
	public Object clone() {
		return new MembersGroup(id,
				(title != null) ? title.clone() : null,
				(description != null) ? description.clone() : null,
			joinable,
			((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
	
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean joinable = Boolean.FALSE;
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<User> members = new LinkedList<>();
}