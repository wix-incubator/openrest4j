package com.wix.restaurants.fees;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Amount.class, name = Amount.TYPE),
        @JsonSubTypes.Type(value = Percentage.class, name = Percentage.TYPE),
})
public abstract class Value implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public Value() {}

    @Override
    public Value clone() {
        try {
            return (Value) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

