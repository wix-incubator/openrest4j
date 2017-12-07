package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.Map;

/** Satisfied if an order is submitted by a given platform. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlatformCondition extends Condition {
    public static final String TYPE = "order_platform";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderPlatformCondition() {}
    
    public OrderPlatformCondition(String platform, Map<String, String> properties) {
    	super(properties);
    	this.platform = platform;
    }

    @Override
    public OrderPlatformCondition clone() {
        return cloneImpl();
    }

    @Override
    protected OrderPlatformCondition cloneImpl() {
        return new OrderPlatformCondition(platform,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderPlatformCondition that = (OrderPlatformCondition) o;

        return platform != null ? platform.equals(that.platform) : that.platform == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public String platform;
}