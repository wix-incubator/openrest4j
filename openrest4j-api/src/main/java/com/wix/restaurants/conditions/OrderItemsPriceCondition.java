package com.wix.restaurants.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Matches the order's total items price against a given range. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemsPriceCondition extends Condition {
    public static final String TYPE = "order_items_price";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderItemsPriceCondition() {}
    
    public OrderItemsPriceCondition(Integer min, Integer max, Map<String, String> properties) {
    	super(properties);
    	this.min = min;
    	this.max = max;
    }

    @Override
    public OrderItemsPriceCondition clone() {
        return cloneImpl();
    }

    @Override
    protected OrderItemsPriceCondition cloneImpl() {
        return new OrderItemsPriceCondition(min, max,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderItemsPriceCondition that = (OrderItemsPriceCondition) o;

        if (min != null ? !min.equals(that.min) : that.min != null) return false;
        return max != null ? max.equals(that.max) : that.max == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (min != null ? min.hashCode() : 0);
        result = 31 * result + (max != null ? max.hashCode() : 0);
        return result;
    }

	/** Minimum order price (null means no minimum) */
    @JsonInclude(Include.NON_NULL)
    public Integer min;
    
	/** Maximum order price (null means no maximum) */
    @JsonInclude(Include.NON_NULL)
    public Integer max;
}