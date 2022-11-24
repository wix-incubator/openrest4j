package com.wix.restaurants.fees;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

public class Percentage extends Value implements Serializable, Cloneable {
    public static final String TYPE = "Percentage";
    private static final long serialVersionUID = 1L;

    public Percentage() {}

    public Percentage(Double value) {
        this.value = value;
    }

    @Override
    public Percentage clone() {
        return new Percentage(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Percentage that = (Percentage) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Double value;
}