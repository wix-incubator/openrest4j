package com.wix.restaurants.orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/** Online ordering settings. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public OrdersInfo() {}

    public OrdersInfo(Availability availability,
                      AsapOrdersInfo asap,
                      FutureOrdersInfo future,
                      Map<String, String> properties) {
        this.availability = availability;
        this.asap = asap;
        this.future = future;
        this.properties = properties;
    }

    @Override
    public Object clone() {
        return new OrdersInfo(
                (availability != null) ? (Availability) availability.clone() : null,
                (asap != null) ? (AsapOrdersInfo) asap.clone() : null,
                (future != null) ? (FutureOrdersInfo) future.clone() : null,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersInfo that = (OrdersInfo) o;

        if (availability != null ? !availability.equals(that.availability) : that.availability != null) return false;
        if (asap != null ? !asap.equals(that.asap) : that.asap != null) return false;
        if (future != null ? !future.equals(that.future) : that.future != null) return false;
        return properties != null ? properties.equals(that.properties) : that.properties == null;

    }

    @Override
    public int hashCode() {
        int result = availability != null ? availability.hashCode() : 0;
        result = 31 * result + (asap != null ? asap.hashCode() : 0);
        result = 31 * result + (future != null ? future.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    /** The restaurant accepts online orders during these times. */
    @JsonInclude(Include.NON_NULL)
    public Availability availability;

    /** Settings for regular (ASAP) orders. */
    @JsonInclude(Include.NON_NULL)
    public AsapOrdersInfo asap;

    /** Settings for future orders. */
    @JsonInclude(Include.NON_NULL)
    public FutureOrdersInfo future;

    /**
     * Map of user-defined extended properties.
     * Developers should use unique keys, e.g. "com.example.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> properties;
}
