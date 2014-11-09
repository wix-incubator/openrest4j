package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItem implements Serializable, Cloneable {
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
    public List<Variation> variations = new LinkedList<Variation>();

    /** The ordered-item's chosen variations. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<List<OrderItem>> variationsChoices = new LinkedList<List<OrderItem>>();

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

    private static final long serialVersionUID = 1L;
}
