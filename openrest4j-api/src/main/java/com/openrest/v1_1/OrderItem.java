package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItem implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public OrderItem(String itemId, List<Variation> variations, List<List<OrderItem>> variationsChoices,
            String comment, Integer price, Integer count) {
        this.itemId = itemId;
        this.variations = variations;
        this.variationsChoices = variationsChoices;
        this.comment = comment;
        this.price = price;
        this.count = count;
    }

    /** Default constructor for JSON deserialization. */
    public OrderItem() {}
    
    @Override
	public Object clone() {
    	final List<List<OrderItem>> clonedVariationsChoices;
    	if (variationsChoices != null) {
    		clonedVariationsChoices = new LinkedList<List<OrderItem>>();
    		for (List<OrderItem> orderItems : variationsChoices) {
    			clonedVariationsChoices.add(OrderItem.clone(orderItems));
    		}
    	} else {
    		clonedVariationsChoices = null;
    	}

    	return new OrderItem(itemId, Variation.clone(variations), clonedVariationsChoices, comment, price, count);
	}
    
    public static List<OrderItem> clone(List<OrderItem> orderItems) {
    	if (orderItems == null) {
    		return null;
    	}
    	
    	final List<OrderItem> cloned = new LinkedList<OrderItem>();
		for (OrderItem orderItem : orderItems) {
			cloned.add((orderItem != null) ? (OrderItem) orderItem.clone() : null);
		}
    	return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (comment != null ? !comment.equals(orderItem.comment) : orderItem.comment != null) return false;
        if (count != null ? !count.equals(orderItem.count) : orderItem.count != null) return false;
        if (itemId != null ? !itemId.equals(orderItem.itemId) : orderItem.itemId != null) return false;
        if (price != null ? !price.equals(orderItem.price) : orderItem.price != null) return false;
        if (variations != null ? !variations.equals(orderItem.variations) : orderItem.variations != null) return false;
        if (variationsChoices != null ? !variationsChoices.equals(orderItem.variationsChoices) : orderItem.variationsChoices != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + (variations != null ? variations.hashCode() : 0);
        result = 31 * result + (variationsChoices != null ? variationsChoices.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
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
}
