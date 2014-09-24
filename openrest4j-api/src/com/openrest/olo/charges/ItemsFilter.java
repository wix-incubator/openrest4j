package com.openrest.olo.charges;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsFilter implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	/** Inclusive: refers to given items. */
	public static final String TYPE_INCLUDE = "include";
    /** Exclusive: refers to anything but the given items. */
    public static final String TYPE_EXCLUDE = "exclude";
    
    /** All known modes. */
    public static final Set<String> ALL_TYPES = new HashSet<String>(Arrays.asList(
    		TYPE_INCLUDE, TYPE_EXCLUDE
    ));
    
    /** Default constructor for JSON deserialization. */
    public ItemsFilter() {}
    
    public ItemsFilter(String type, Set<String> itemIds) {
        this.type = type;
        this.itemIds = itemIds;
    }
    
    @Override
	public Object clone() {
    	return new ItemsFilter(type,
    			((itemIds != null) ? new LinkedHashSet<String>(itemIds) : null));
	}

    @JsonInclude(Include.NON_NULL)
    public String type;

    /** Items for which the charge applies, null if applies for every item. */
    @JsonInclude(Include.NON_NULL)
    public Set<String> itemIds;
}
