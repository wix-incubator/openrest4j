package com.wix.restaurants;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IntegerInterval implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public IntegerInterval() {}

    public IntegerInterval(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public IntegerInterval clone() {
        return new IntegerInterval(min, max);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegerInterval that = (IntegerInterval) o;

        if (min != null ? !min.equals(that.min) : that.min != null) return false;
        return max != null ? max.equals(that.max) : that.max == null;

    }

    @Override
    public int hashCode() {
        int result = min != null ? min.hashCode() : 0;
        result = 31 * result + (max != null ? max.hashCode() : 0);
        return result;
    }

    /** Minimum value allowed, or null for no minimum. */
    @JsonInclude(Include.NON_NULL)
    public Integer min;

    /** Maximum value allowed, or null for no maximum. */
    @JsonInclude(Include.NON_NULL)
    public Integer max;
}
