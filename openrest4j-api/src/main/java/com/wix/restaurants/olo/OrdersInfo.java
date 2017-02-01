package com.wix.restaurants.olo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.IntegerInterval;
import com.wix.restaurants.availability.Availability;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public OrdersInfo() {}

    public OrdersInfo(Availability availability,
                      IntegerInterval futureDelayMins,
                      Map<String, String> properties) {
        this.availability = availability;
        this.futureDelayMins = futureDelayMins;
        this.properties = properties;
    }

    @Override
    public Object clone() {
        return new OrdersInfo(
                (availability != null) ? (Availability) availability.clone() : null,
                (futureDelayMins != null) ? (IntegerInterval) futureDelayMins.clone() : null,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersInfo that = (OrdersInfo) o;

        if (availability != null ? !availability.equals(that.availability) : that.availability != null) return false;
        if (futureDelayMins != null ? !futureDelayMins.equals(that.futureDelayMins) : that.futureDelayMins != null) return false;
        return properties != null ? properties.equals(that.properties) : that.properties == null;

    }

    @Override
    public int hashCode() {
        int result = availability != null ? availability.hashCode() : 0;
        result = 31 * result + (futureDelayMins != null ? futureDelayMins.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    /**
     * The restaurant accepts online orders to these times.
     * @see #futureDelayMins for limitations.
     */
    @JsonInclude(Include.NON_NULL)
    public Availability availability;

    /**
     * Time interval in which future orders are allowed (minimum is mandatory, and non-negative),
     * or null if future orders are not allowed.
     *
     * For example, min=1440 max=10080 means that future orders must be placed at least 1 day in advance,
     * and at most 7 days in advance.
     */
    @JsonInclude(Include.NON_NULL)
    public IntegerInterval futureDelayMins;

    /**
     * Map of user-defined extended properties.
     * Developers should use unique keys, e.g. "com.example.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> properties;
}
