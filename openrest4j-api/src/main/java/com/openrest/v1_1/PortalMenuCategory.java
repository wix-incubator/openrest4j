package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PortalMenuCategory implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public PortalMenuCategory(Map<Locale, String> title, Map<Locale, String> description,
							  List<PortalMenuCategory> children, Set<String> features, Map<String, String> properties) {
    	this.title = title;
    	this.description = description;
    	this.children = children;
    	this.features = features;
    	this.properties = properties;
    }

    /** Default constructor for JSON deserialization. */
    public PortalMenuCategory() {}
    
    public static List<PortalMenuCategory> cloneList(List<PortalMenuCategory> categories) {
    	final List<PortalMenuCategory> clonedCategories;
    	if (categories != null) {
    		clonedCategories = new LinkedList<PortalMenuCategory>();
    		for (PortalMenuCategory category : categories) {
    			clonedCategories.add((category != null) ? (PortalMenuCategory) category.clone() : null);
    		}
    	} else {
    		clonedCategories = null;
    	}
    	return clonedCategories;
    }
    
    @Override
	public Object clone() {
    	return new PortalMenuCategory(
    			((title != null) ? new LinkedHashMap<>(title) : null),
    			((description != null) ? new LinkedHashMap<>(description) : null),
    			cloneList(children),
    			((features != null) ? new LinkedHashSet<>(features) : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((features == null) ? 0 : features.hashCode());
		result = prime * result
				+ ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortalMenuCategory other = (PortalMenuCategory) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "PortalMenuCategory [title=" + title + ", description="
				+ description + ", children=" + children + ", features="
				+ features + ", properties=" + properties + "]";
	}
	
    /** Localized title. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<Locale, String> title = new LinkedHashMap<>();

    /** Localized description. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<Locale, String> description = new LinkedHashMap<>();

    /** Sub-categories. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<PortalMenuCategory> children = new LinkedList<>();

    /** Features to display. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> features = new LinkedHashSet<>();
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
