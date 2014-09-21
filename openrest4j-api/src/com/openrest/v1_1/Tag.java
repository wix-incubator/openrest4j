package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** A set of items that go together, e.g. "sides", "drinks", "toppings". */
@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
	/** Inclusive: tag refers to given items. */
	public static final String TAG_MODE_INCLUDE = "include";
    /** Exclusive: tag refers to anything but the given items. */
    public static final String TAG_MODE_EXCLUDE = "exclude";
    
    /** All known tag modes */
    public static final Set<String> ALL_TAG_MODES = new HashSet<String>(Arrays.asList(new String[] {
    		TAG_MODE_INCLUDE, TAG_MODE_EXCLUDE
    }));
	
    /** Constructs a previously submitted tag from persisted data. */
    public Tag(String id, String restaurantId, Map<String, String> title,
    		List<String> itemIds, Map<String, String> properties) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.title = title;
        this.itemIds = itemIds;
        this.properties = properties;
    }
    
    public static List<Tag> clone(List<Tag> tags) {
    	if (tags == null) {
    		return null;
    	}
    	
    	final List<Tag> cloned = new LinkedList<Tag>();
    	for (Tag tag : tags) {
    		cloned.add((tag != null) ? (Tag) tag.clone() : null);
    	}
    	return cloned;
    }

    @Override
	public Object clone() {
    	return new Tag(id, restaurantId,
    			((title != null) ? new HashMap<String, String>(title) : null),
    			new LinkedList<String>(itemIds),
    			((properties != null) ? new HashMap<String, String>(properties) : null));
	}

    /** Default constructor for JSON deserialization. */
    public Tag() {}

    /** The tag's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The restaurant's id. */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;

    /** The tag's name in various locales, e.g. "drink", "sides". */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new HashMap<String, String>();

    /** Item ids. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<String> itemIds = new LinkedList<String>();

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemIds == null) ? 0 : itemIds.hashCode());
		result = prime * result
				+ ((properties == null) ? 0 : properties.hashCode());
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
		Tag other = (Tag) obj;
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
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
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
}
