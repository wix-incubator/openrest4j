package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecretPosInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public static final String ID = "com.wix.restaurants.pos";

    /** Default constructor for JSON deserialization. */
    public SecretPosInfo() {}

    public SecretPosInfo(String posId, Map<String, String> endpointKeys) {
        this.posId = posId;
        this.endpointKeys = endpointKeys;
    }

    @Override
    public Object clone() {
        return new SecretPosInfo(posId,
                ((endpointKeys != null) ? new LinkedHashMap<>(endpointKeys) : null));
    }

    /** POS to use for order submission (null means none). */
    @JsonInclude(Include.NON_NULL)
    public String posId;

    /** Maps POS systems to their opaque endpoint keys. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> endpointKeys = new LinkedHashMap<>();
}
