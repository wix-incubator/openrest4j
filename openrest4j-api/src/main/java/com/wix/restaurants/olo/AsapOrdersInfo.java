package com.wix.restaurants.olo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

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
    public Object clone() {
        return new AsapOrdersInfo(disabled, preOrderMins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsapOrdersInfo that = (AsapOrdersInfo) o;

        if (disabled != null ? !disabled.equals(that.disabled) : that.disabled != null) return false;
        return preOrderMins != null ? preOrderMins.equals(that.preOrderMins) : that.preOrderMins == null;
    }

    @Override
    public int hashCode() {
        int result = disabled != null ? disabled.hashCode() : 0;
        result = 31 * result + (preOrderMins != null ? preOrderMins.hashCode() : 0);
        return result;
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
