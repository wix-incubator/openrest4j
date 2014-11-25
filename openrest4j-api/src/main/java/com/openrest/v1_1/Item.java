package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;

/**
 * An item that can be ordered, e.g. a main dish ("hamburger"), a side ("fries")
 * or a dish variation ("well done").
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable, Cloneable, Comparable<Item> {
	private static final long serialVersionUID = 1L;
	
	/** Label to mark a featured item ("flag dish"). */
	public static final String LABEL_FEATURED = "featured";
    
	/** Constructs a previously submitted item from persisted data. */
    public Item(String id, String restaurantId, Map<String, String> title,
    		Map<String, String> description, Integer price, List<Variation> variations,
    		Availability availability, String picture, Map<String, Blob> blobs,
    		Map<String, String> externalIds, Set<String> labels,
    		Map<String, String> properties, Stock stock, Double rank) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.variations = variations;
        this.availability = availability;
        this.picture = picture;
        this.blobs = blobs;
        this.externalIds = externalIds;
        this.labels = labels;
        this.properties = properties;
        this.stock = stock;
        this.rank = rank;
    }

	/** Default constructor for JSON deserialization. */
    public Item() {}
    
    public static List<Item> clone(List<Item> items) {
    	if (items == null) {
    		return null;
    	}
    	
    	final List<Item> cloned = new LinkedList<Item>();
    	for (Item item : items) {
    		cloned.add((item != null) ? (Item) item.clone() : null);
    	}
    	return cloned;
    }
    
    @Override
	public Object clone() {
    	return new Item(id, restaurantId,
    			((title != null) ? new HashMap<String, String>(title) : null),
    			((description != null) ? new HashMap<String, String>(description) : null),
    			price, Variation.clone(variations),
    			((availability != null) ? (Availability) availability.clone() : null),
    			picture,
    			Blob.clone(blobs),
    			((externalIds != null) ? new HashMap<String, String>(externalIds) : null),
    			((labels != null) ? new HashSet<String>(labels) : null),
    			((properties != null) ? new HashMap<String, String>(properties) : null),
    			stock, rank);
	}

    /** The item's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The restaurant's id. */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;

    /** The item's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new HashMap<String, String>();

    /** The item's one line description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> description = new HashMap<String, String>();

    /** The item's price, in "cents". */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer price = 0;

    /** List of possible variations. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Variation> variations = new LinkedList<Variation>();

    /** Time windows in which this item is regularly available. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability availability = new Availability();

    /** Item picture URL (direct link). */
    @JsonInclude(Include.NON_NULL)
    public String picture;
    
    /**
     * Maps blob-types to blobs.
     * @see GetBlobUploadUrlRequest#blobType
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Blob> blobs = new HashMap<String, Blob>();

    /**
     * Map of externally-defined item ids referring to this item.
     * For example, the item-id in the restaurant's PoS system.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new HashMap<String, String>();

    /** The item's labels, e.g. "new", "spicy". */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> labels = new HashSet<String>();
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
    
    /** (read-only) Stock information (null means inventory is not managed for this item). */
    @JsonInclude(Include.NON_NULL)
    public Stock stock;
    
    /** The item's Openrest rank (higher is better). */
    @JsonInclude(Include.NON_NULL)
    public Double rank;
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((availability == null) ? 0 : availability.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((externalIds == null) ? 0 : externalIds.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((restaurantId == null) ? 0 : restaurantId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((variations == null) ? 0 : variations.hashCode());
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
		Item other = (Item) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (externalIds == null) {
			if (other.externalIds != null)
				return false;
		} else if (!externalIds.equals(other.externalIds))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (labels == null) {
			if (other.labels != null)
				return false;
		} else if (!labels.equals(other.labels))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
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
		if (variations == null) {
			if (other.variations != null)
				return false;
		} else if (!variations.equals(other.variations))
			return false;
		return true;
	}
    
	public int compareTo(Item other) {
		if (rank != null) {
			return ((other.rank != null) ? -rank.compareTo(other.rank) : -1);
		} else {
			return ((other.rank == null) ? (0) : 1);
		}
	}
}
