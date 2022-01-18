package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItem implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public OrderItem(String itemId, List<Variation> variations, List<List<OrderItem>> variationsChoices,
            String comment, Integer price, Integer count) {
        this(itemId, variations, variationsChoices, comment, price, count, null, null, null, null);
    }

    public OrderItem(String itemId, List<Variation> variations, List<List<OrderItem>> variationsChoices,
                     String comment, Integer price, Integer count, LocalizedString title, LocalizedString description,
                     Map<String, String> media, Set<String> labels) {
        this.itemId = itemId;
        this.variations = variations;
        this.variationsChoices = variationsChoices;
        this.comment = comment;
        this.price = price;
        this.count = count;
        this.title = title;
        this.description = description;
        this.media = media;
        this.labels = labels;
    }

    /** Default constructor for JSON deserialization. */
    public OrderItem() {}
    
    @Override
	public OrderItem clone() {
    	final List<List<OrderItem>> clonedVariationsChoices;
    	if (variationsChoices != null) {
    		clonedVariationsChoices = new LinkedList<>();
    		for (List<OrderItem> orderItems : variationsChoices) {
    			clonedVariationsChoices.add(OrderItem.clone(orderItems));
    		}
    	} else {
    		clonedVariationsChoices = null;
    	}

    	return new OrderItem(
    	        itemId,
                Variation.clone(variations),
                clonedVariationsChoices,
                comment,
                price,
                count,
                ((title != null) ? title.clone() : null),
                ((description != null) ? description.clone() : null),
                ((media != null) ? new LinkedHashMap<>(media) : null),
                ((labels != null) ? new LinkedHashSet<>(labels) : null));
	}
    
    public static List<OrderItem> clone(List<OrderItem> orderItems) {
    	if (orderItems == null) {
    		return null;
    	}
    	
    	final List<OrderItem> cloned = new LinkedList<>();
		for (OrderItem orderItem : orderItems) {
			cloned.add((orderItem != null) ? orderItem.clone() : null);
		}
    	return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(itemId, orderItem.itemId) &&
                Objects.equals(variations, orderItem.variations) &&
                Objects.equals(variationsChoices, orderItem.variationsChoices) &&
                Objects.equals(comment, orderItem.comment) &&
                Objects.equals(price, orderItem.price) &&
                Objects.equals(count, orderItem.count) &&
                Objects.equals(title, orderItem.title) &&
                Objects.equals(description, orderItem.description) &&
                Objects.equals(media, orderItem.media) &&
                Objects.equals(labels, orderItem.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, variations, variationsChoices, comment, price, count, title, description, media, labels);
    }

    /** Item id. */
    @JsonInclude(Include.NON_NULL)
    public String itemId;

    /**
     * The ordered-item's variations.
     * 
     * Submitting an OrderItem with empty variations means the defaults should be assumed
     * for variationsChoices.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Variation> variations = new LinkedList<>();

    /** The ordered-item's chosen variations. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<List<OrderItem>> variationsChoices = new LinkedList<>();

    /** Textual comment regarding the item. */
    @JsonInclude(Include.NON_NULL)
    public String comment;

    /**
     * The item's base price (@see Item.price) ignoring variations and counts.
     * 
     * Calculating the total "all-included" item price involves iterating the
     * variationsChoices and recursively summing the prices for sub-items
     * (multiplying by the correct counts, if needed).
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer price = 0;

    /** Number of times this order-item was ordered. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer count = 1;

    /** The item's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;

    /** The item's one line description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString description = LocalizedString.empty;

    /**
     * Maps media-types to URLs.
     * @see BlobTypes
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> media = new LinkedHashMap<>();

    /**
     * The item's labels.
     * @see com.wix.restaurants.Labels
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> labels = new LinkedHashSet<>();
}
