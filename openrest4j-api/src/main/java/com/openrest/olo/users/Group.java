package com.openrest.olo.users;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** A group of users, defined by some rule. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "type")  
@JsonSubTypes({
	@Type(value = CodeGroup.class, name = CodeGroup.TYPE),
	@Type(value = MembersGroup.class, name = MembersGroup.TYPE)
})
public abstract class Group implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** View the group as any random person. */
    public static final String GROUP_VIEW_MODE_ANYONE = "anyone";
    /** View the group as a group member. */
    public static final String GROUP_VIEW_MODE_MEMBER = "member";
    /** View the group as a group manager. */
    public static final String GROUP_VIEW_MODE_MANAGER = "manager";
    
    /** All known group view modes. */
    public static final Set<String> ALL_GROUP_VIEW_MODES = new HashSet<String>(Arrays.asList(new String[] {
    		GROUP_VIEW_MODE_ANYONE, GROUP_VIEW_MODE_MEMBER, GROUP_VIEW_MODE_MANAGER
    }));
    
    /** Default constructor for JSON deserialization. */
    public Group() {}
    
    public Group(String id, Map<String, String> title, Map<String, String> description, Map<String, String> properties) {
    	this.id = id;
    	this.title = title;
    	this.description = description;
    	this.properties = properties;
    }
    
    @Override
	public abstract Object clone();
    
	/** The group's unique ID. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** The group's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new LinkedHashMap<String, String>();

    /** The group's description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> description = new LinkedHashMap<String, String>();
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<String, String>();
}
