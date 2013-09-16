package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category implements Serializable, Cloneable, Comparable<Category> {
    private static final long serialVersionUID = 1L;
    
	/** Constructs a previously submitted category from persisted data. */
    public Category(String id, String restaurantId, Map<String, String> title,
    		Map<String, String> description, String parentCategoryId,
    		List<String> itemIds, Double priority, Map<String, String> properties) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.title = title;
        this.description = description;
        this.parentCategoryId = parentCategoryId;
        this.itemIds = itemIds;
        this.priority = priority;
        this.properties = properties;
    }

    /** Constructs a new category to be submitted. */
    public Category(Map<String, String> title, Map<String, String> description,
    		String parentCategoryId, List<String> itemIds, Double priority,
    		Map<String, String> properties) {
        this(null, null, title, description, parentCategoryId, itemIds, priority, properties);
    }

    /** Default constructor for JSON deserialization. */
    public Category() {}
    
    @Override
	public Object clone() {
    	return new Category(id, restaurantId,
    			((title != null) ? new HashMap<String, String>(title) : null),
    			((description != null) ? new HashMap<String, String>(description) : null),
    			parentCategoryId,
    			((itemIds != null) ? new ArrayList<String>(itemIds) : null),
    			priority,
    			((properties != null) ? new HashMap<String, String>(properties) : null));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemIds == null) ? 0 : itemIds.hashCode());
		result = prime
				* result
				+ ((parentCategoryId == null) ? 0 : parentCategoryId.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result
				+ ((restaurantId == null) ? 0 : restaurantId.hashCode());
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
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemIds == null) {
			if (other.itemIds != null)
				return false;
		} else if (!itemIds.equals(other.itemIds))
			return false;
		if (parentCategoryId == null) {
			if (other.parentCategoryId != null)
				return false;
		} else if (!parentCategoryId.equals(other.parentCategoryId))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (restaurantId == null) {
			if (other.restaurantId != null)
				return false;
		} else if (!restaurantId.equals(other.restaurantId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int compareTo(Category other) {
		return Double.compare(
				((priority != null) ? priority.doubleValue() : 0),
				((other.priority != null) ? other.priority.doubleValue() : 0));
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", restaurantId=" + restaurantId
				+ ", title=" + title + ", description=" + description
				+ ", parentCategoryId=" + parentCategoryId + ", itemIds="
				+ itemIds + ", priority=" + priority + "]";
	}

    /** The category's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The restaurant's id. */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;

    /** The category's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new HashMap<String, String>();

    /** The category's description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> description = new HashMap<String, String>();

    /** The parent category's id. */
    @JsonInclude(Include.NON_NULL)
    public String parentCategoryId;

    /** The item-ids in this category. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<String> itemIds = new LinkedList<String>();

    /** Order priority. Lower numbers appear first in the list. */
    @JsonInclude(Include.NON_DEFAULT)
    public Double priority = 0.0;
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
}
