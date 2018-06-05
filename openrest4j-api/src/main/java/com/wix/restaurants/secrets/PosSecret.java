package com.wix.restaurants.secrets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PosSecret implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public static final String ID = "com.wix.restaurants.pos";

    /** Default constructor for JSON deserialization. */
    public PosSecret() {}

    public PosSecret(String posId, Map<String, String> endpointKeys) {
        this.posId = posId;
        this.endpointKeys = endpointKeys;
    }

    @Override
    public PosSecret clone() {
        return new PosSecret(posId,
                ((endpointKeys != null) ? new LinkedHashMap<>(endpointKeys) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosSecret posSecret = (PosSecret) o;
        return Objects.equals(posId, posSecret.posId) &&
                Objects.equals(endpointKeys, posSecret.endpointKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posId, endpointKeys);
    }

    @Override
    public String toString() {
        return "PosSecret{" +
                "posId='" + posId + '\'' +
                ", endpointKeys=" + endpointKeys +
                '}';
    }

    /** POS to use for order submission (null means none). */
    @JsonInclude(Include.NON_NULL)
    public String posId;

    /** Maps POS systems to their opaque endpoint keys. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> endpointKeys = new LinkedHashMap<>();
}
