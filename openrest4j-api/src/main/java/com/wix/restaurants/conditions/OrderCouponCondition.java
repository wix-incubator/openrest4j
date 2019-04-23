package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.Map;

/** Satisfied if an order is submitted with a given coupon. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCouponCondition extends Condition {
    public static final String TYPE = "order_coupon";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public OrderCouponCondition() {}

    public OrderCouponCondition(String couponHashCode, Map<String, String> properties) {
    	super(properties);
    	this.couponHashCode = couponHashCode;
    }

    @Override
    public OrderCouponCondition clone() {
        return cloneImpl();
    }

    @Override
    protected OrderCouponCondition cloneImpl() {
        return new OrderCouponCondition(couponHashCode,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderCouponCondition that = (OrderCouponCondition) o;

        return couponHashCode != null ? couponHashCode.equals(that.couponHashCode) : that.couponHashCode == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (couponHashCode != null ? couponHashCode.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public String couponHashCode;
}