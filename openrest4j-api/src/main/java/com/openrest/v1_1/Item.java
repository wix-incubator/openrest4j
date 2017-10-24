package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.conditions.Condition;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.*;

/**
 * An item that can be ordered, e.g. a main dish ("hamburger"), a side ("fries")
 * or a dish variation ("well done").
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable, Cloneable, Comparable<Item> {
	private static final long serialVersionUID = 1L;
	
	/** Constructs a previously submitted item from persisted data. */
    public Item(String id, String restaurantId, LocalizedString title,
				LocalizedString description, Integer price, List<Variation> variations,
				Condition displayCondition, Condition condition,
				Availability availability, String picture, Map<String, Blob> blobs,
				Map<String, String> externalIds, Set<String> labels,
				Map<String, String> properties, Stock stock, Integer maxCommentLength, Double rank) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.variations = variations;
        this.displayCondition = displayCondition;
		this.condition = condition;
        this.availability = availability;
        this.picture = picture;
        this.blobs = blobs;
        this.externalIds = externalIds;
        this.labels = labels;
        this.properties = properties;
        this.stock = stock;
        this.maxCommentLength = maxCommentLength;
        this.rank = rank;
    }

	/** Default constructor for JSON deserialization. */
    public Item() {}
    
    public static List<Item> clone(List<Item> items) {
    	if (items == null) {
    		return null;
    	}
    	
    	final List<Item> cloned = new LinkedList<>();
    	for (Item item : items) {
    		cloned.add((item != null) ? (Item) item.clone() : null);
    	}
    	return cloned;
    }
    
    @Override
	public Object clone() {
    	return new Item(id, restaurantId,
    			((title != null) ? (LocalizedString) title.clone() : null),
    			((description != null) ? (LocalizedString) description.clone() : null),
    			price, Variation.clone(variations),
                (displayCondition != null) ? (Condition) displayCondition.clone() : null,
                (condition != null) ? (Condition) condition.clone() : null,
    			((availability != null) ? (Availability) availability.clone() : null),
    			picture,
    			Blob.clone(blobs),
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
    			((labels != null) ? new LinkedHashSet<>(labels) : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			stock, maxCommentLength, rank);
	}

    /** The item's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The restaurant's id. */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;

    /** The item's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;

    /** The item's one line description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString description = LocalizedString.empty;

    /** The item's price, in "cents". */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer price = 0;

    /** List of possible variations. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Variation> variations = new LinkedList<>();

    /** Condition to display the item to end-users, e.g you can have a secret item that only shows up in certain hours. */
    @JsonInclude(Include.NON_NULL)
    public Condition displayCondition;

    /** Condition to order the item, e.g. you can have an item that's only available for ordering in certain hours. */
    @JsonInclude(Include.NON_NULL)
    public Condition condition;

    /** Time windows in which this item is regularly available. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability availability = new Availability();

    /** Item picture URL (direct link). */
    @JsonInclude(Include.NON_NULL)
    public String picture;
    
    /**
     * Maps blob-types to blobs.
	 * @see BlobTypes
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Blob> blobs = new LinkedHashMap<>();

    /**
     * Map of externally-defined item ids referring to this item.
     * For example, the item-id in the restaurant's PoS system.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<>();

    /**
     * The item's labels.
     * @see com.wix.restaurants.Labels
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> labels = new LinkedHashSet<>();
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
    
    /** (read-only) Stock information (null means inventory is not managed for this item). */
    @JsonInclude(Include.NON_NULL)
    public Stock stock;

    /**
     * Maximum allowed length (in characters) for order item comment, or null if unlimited.
     * A value of 0 means comments are disabled for this item.
     *
     * @see OrderItem#comment
     */
    @JsonInclude(Include.NON_NULL)
    public Integer maxCommentLength;

    /** The item's Openrest rank (higher is better). */
    @JsonInclude(Include.NON_NULL)
    public Double rank;

	public int compareTo(Item other) {
		if (rank != null) {
			return ((other.rank != null) ? -rank.compareTo(other.rank) : -1);
		} else {
			return ((other.rank == null) ? (0) : 1);
		}
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (restaurantId != null ? !restaurantId.equals(item.restaurantId) : item.restaurantId != null) return false;
        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (variations != null ? !variations.equals(item.variations) : item.variations != null) return false;
        if (displayCondition != null ? !displayCondition.equals(item.displayCondition) : item.displayCondition != null) return false;
        if (condition != null ? !condition.equals(item.condition) : item.condition != null) return false;
        if (availability != null ? !availability.equals(item.availability) : item.availability != null) return false;
        if (picture != null ? !picture.equals(item.picture) : item.picture != null) return false;
        if (blobs != null ? !blobs.equals(item.blobs) : item.blobs != null) return false;
        if (externalIds != null ? !externalIds.equals(item.externalIds) : item.externalIds != null) return false;
        if (labels != null ? !labels.equals(item.labels) : item.labels != null) return false;
        if (properties != null ? !properties.equals(item.properties) : item.properties != null) return false;
        if (stock != null ? !stock.equals(item.stock) : item.stock != null) return false;
        if (maxCommentLength != null ? !maxCommentLength.equals(item.maxCommentLength) : item.maxCommentLength != null) return false;
        return rank != null ? rank.equals(item.rank) : item.rank == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (variations != null ? variations.hashCode() : 0);
        result = 31 * result + (displayCondition != null ? displayCondition.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (blobs != null ? blobs.hashCode() : 0);
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        result = 31 * result + (labels != null ? labels.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (maxCommentLength != null ? maxCommentLength.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }
}
