package com.wix.restaurants.orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.IntegerInterval;

import java.io.Serializable;

/** Settings for future orders. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FutureOrdersInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public FutureOrdersInfo() {}

    public FutureOrdersInfo(Boolean disabled,
                            IntegerInterval delayMins) {
        this.disabled = disabled;
        this.delayMins = delayMins;
    }

    @Override
    public Object clone() {
        return new FutureOrdersInfo(disabled, delayMins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FutureOrdersInfo that = (FutureOrdersInfo) o;

        if (disabled != null ? !disabled.equals(that.disabled) : that.disabled != null) return false;
        return delayMins != null ? delayMins.equals(that.delayMins) : that.delayMins == null;
    }

    @Override
    public int hashCode() {
        int result = disabled != null ? disabled.hashCode() : 0;
        result = 31 * result + (delayMins != null ? delayMins.hashCode() : 0);
        return result;
    }

    /** Whether or not future ordering is disabled. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean disabled = Boolean.FALSE;

    /**
     * Time interval in which future orders are allowed (minimum is mandatory, and non-negative).
     *
     * For example, min=1440 max=10080 means that future orders must be placed at least 1 day in advance,
     * and at most 7 days in advance.
     */
    @JsonInclude(Include.NON_NULL)
    public IntegerInterval delayMins;
}
