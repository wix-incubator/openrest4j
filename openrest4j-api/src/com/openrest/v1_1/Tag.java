package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A set of items that go together, e.g. "sides", "drinks", "toppings".
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag implements Serializable {
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

    /** Constructs a new tag to be submitted. */
    public Tag(Map<String, String> title, List<String> itemIds, Map<String, String> properties) {
        this(null, null, title, itemIds, properties);
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
    public List<String> itemIds = new ArrayList<String>();

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
}
