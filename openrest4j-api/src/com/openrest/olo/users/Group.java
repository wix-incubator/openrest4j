package com.openrest.olo.users;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

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
	@Type(value = RoleGroup.class, name = RoleGroup.TYPE),
	@Type(value = MembersGroup.class, name = MembersGroup.TYPE)
})
public abstract class Group implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
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
