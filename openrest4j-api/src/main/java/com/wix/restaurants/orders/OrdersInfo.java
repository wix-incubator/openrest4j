package com.wix.restaurants.orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Online ordering settings. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public OrdersInfo() {}

    public OrdersInfo(Availability availability,
                      AsapOrdersInfo asap,
                      FutureOrdersInfo future,
                      Integer maxCommentLength,
                      Map<String, String> properties) {
        this.availability = availability;
        this.asap = asap;
        this.future = future;
        this.maxCommentLength = maxCommentLength;
        this.properties = properties;
    }

    public OrdersInfo(Availability availability,
                      AsapOrdersInfo asap,
                      FutureOrdersInfo future,
                      Integer maxCommentLength,
                      RoundingStrategy roundingStrategy,
                      Map<String, String> properties) {
        this.availability = availability;
        this.asap = asap;
        this.future = future;
        this.maxCommentLength = maxCommentLength;
        this.roundingStrategy = roundingStrategy;
        this.properties = properties;
    }

    @Override
    public OrdersInfo clone() {
        return new OrdersInfo(
                (availability != null) ? availability.clone() : null,
                (asap != null) ? asap.clone() : null,
                (future != null) ? future.clone() : null,
                maxCommentLength,
                roundingStrategy,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersInfo that = (OrdersInfo) o;
        return Objects.equals(availability, that.availability) &&
                Objects.equals(asap, that.asap) &&
                Objects.equals(future, that.future) &&
                Objects.equals(maxCommentLength, that.maxCommentLength) &&
                Objects.equals(roundingStrategy, that.roundingStrategy) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availability, asap, future, maxCommentLength, roundingStrategy, properties);
    }

    /** The restaurant accepts online orders during these times. */
    @JsonInclude(Include.NON_NULL)
    public Availability availability = new Availability();

    /** Settings for regular (ASAP) orders. */
    @JsonInclude(Include.NON_NULL)
    public AsapOrdersInfo asap = new AsapOrdersInfo();

    /** Settings for future orders. */
    @JsonInclude(Include.NON_NULL)
    public FutureOrdersInfo future = new FutureOrdersInfo();

    /**
     * Maximum allowed length (in characters) for order comment, or null if unlimited.
     * A value of 0 means order comments are disabled.
     *
     * @see com.openrest.v1_1.Order#comment
     */
    @JsonInclude(Include.NON_NULL)
    public Integer maxCommentLength;

    /** Rounding method for charges calculation. */
    @JsonInclude(Include.NON_NULL)
    public RoundingStrategy roundingStrategy;

    /**
     * Map of user-defined extended properties.
     * Developers should use unique keys, e.g. "com.example.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> properties = new LinkedHashMap<>();
}
