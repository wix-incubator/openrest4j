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
    public Item(String id, LocalizedString title,
				LocalizedString description, Integer price, List<Variation> variations,
				Condition displayCondition, Condition condition,
				Availability availability, Map<String, Blob> blobs,
				Map<String, String> media, Map<String, String> externalIds, Set<String> labels,
				Map<String, String> properties, Stock stock, Integer maxCommentLength) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.variations = variations;
        this.displayCondition = displayCondition;
		this.condition = condition;
        this.availability = availability;
        this.blobs = blobs;
        this.media = media;
        this.externalIds = externalIds;
        this.labels = labels;
        this.properties = properties;
        this.stock = stock;
        this.maxCommentLength = maxCommentLength;
    }

	/** Default constructor for JSON deserialization. */
    public Item() {}
    
    public static List<Item> clone(List<Item> items) {
    	if (items == null) {
    		return null;
    	}
    	
    	final List<Item> cloned = new LinkedList<>();
    	for (Item item : items) {
    		cloned.add((item != null) ? item.clone() : null);
    	}
    	return cloned;
    }
    
    @Override
	public Item clone() {
    	return new Item(id,
    			((title != null) ? title.clone() : null),
    			((description != null) ? description.clone() : null),
    			price, Variation.clone(variations),
                (displayCondition != null) ? displayCondition.clone() : null,
                (condition != null) ? condition.clone() : null,
    			((availability != null) ? availability.clone() : null),
    			Blob.clone(blobs),
                ((media != null) ? new LinkedHashMap<>(media) : null),
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
    			((labels != null) ? new LinkedHashSet<>(labels) : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			stock, maxCommentLength);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(title, item.title) &&
                Objects.equals(description, item.description) &&
                Objects.equals(price, item.price) &&
                Objects.equals(variations, item.variations) &&
                Objects.equals(displayCondition, item.displayCondition) &&
                Objects.equals(condition, item.condition) &&
                Objects.equals(availability, item.availability) &&
                Objects.equals(blobs, item.blobs) &&
                Objects.equals(media, item.media) &&
                Objects.equals(externalIds, item.externalIds) &&
                Objects.equals(labels, item.labels) &&
                Objects.equals(properties, item.properties) &&
                Objects.equals(stock, item.stock) &&
                Objects.equals(maxCommentLength, item.maxCommentLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, variations, displayCondition, condition, availability, blobs, media, externalIds, labels, properties, stock, maxCommentLength);
    }

    public int compareTo(Item other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title=" + title +
                ", description=" + description +
                ", price=" + price +
                ", variations=" + variations +
                ", displayCondition=" + displayCondition +
                ", condition=" + condition +
                ", availability=" + availability +
                ", blobs=" + blobs +
                ", media=" + media +
                ", externalIds=" + externalIds +
                ", labels=" + labels +
                ", properties=" + properties +
                ", stock=" + stock +
                ", maxCommentLength=" + maxCommentLength +
                '}';
    }

    /** The item's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

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

    /**
     * Maps blob-types to blobs.
	 * @see BlobTypes
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Blob> blobs = new LinkedHashMap<>();

    /**
     * Maps media-types to URLs.
     * @see BlobTypes
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> media;

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
}
