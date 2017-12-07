package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.Map;

/** Matches the order's delivery type against a given delivery type. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDeliveryTypeCondition extends Condition {
    public static final String TYPE = "order_delivery_type";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderDeliveryTypeCondition() {}
    
    public OrderDeliveryTypeCondition(String deliveryType, Map<String, String> properties) {
    	super(properties);
    	this.deliveryType = deliveryType;
    }

    @Override
    public OrderDeliveryTypeCondition clone() {
        return cloneImpl();
    }

    @Override
    protected OrderDeliveryTypeCondition cloneImpl() {
        return new OrderDeliveryTypeCondition(deliveryType,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderDeliveryTypeCondition that = (OrderDeliveryTypeCondition) o;

        return deliveryType != null ? deliveryType.equals(that.deliveryType) : that.deliveryType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (deliveryType != null ? deliveryType.hashCode() : 0);
        return result;
    }

	/** @see com.openrest.olo.dispatches.Dispatch */
    @JsonInclude(Include.NON_NULL)
    public String deliveryType;
}