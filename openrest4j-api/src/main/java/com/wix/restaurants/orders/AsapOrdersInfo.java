package com.wix.restaurants.orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

/** Settings for regular (ASAP) orders. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AsapOrdersInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public AsapOrdersInfo() {}

    public AsapOrdersInfo(Boolean disabled,
                          Integer preOrderMins) {
        this.disabled = disabled;
        this.preOrderMins = preOrderMins;
    }

    @Override
    public AsapOrdersInfo clone() {
        return new AsapOrdersInfo(disabled, preOrderMins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsapOrdersInfo that = (AsapOrdersInfo) o;
        return Objects.equals(disabled, that.disabled) &&
                Objects.equals(preOrderMins, that.preOrderMins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disabled, preOrderMins);
    }

    /** Whether or not ASAP ordering is disabled. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean disabled = Boolean.FALSE;

    /**
     * How much time in advance can pre-orders be placed. Pre-orders are handled just like regular orders that are
     * submitted the moment the restaurant opens.
     *
     * @see com.openrest.v1_1.Order#submitAt
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer preOrderMins;
}
