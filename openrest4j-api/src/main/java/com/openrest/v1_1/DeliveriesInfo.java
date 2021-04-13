package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

/** Policies that apply to all delivery dispatches. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveriesInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Approximate addresses are disallowed. */
    public static final String APPROXIMATE_ADDRESSES_DISALLOW = "disallow";
    /** Approximate addresses are allowed, but customers must be warned. */
    public static final String APPROXIMATE_ADDRESSES_WARN = "warn";
    /** Approximate addresses are allowed, and customers should not be warned. */
    public static final String APPROXIMATE_ADDRESSES_ALLOW = "allow";

    public static final Set<String> ALL_APPROXIMATE_ADDRESSES = new HashSet<>(Arrays.asList(
            APPROXIMATE_ADDRESSES_DISALLOW, APPROXIMATE_ADDRESSES_WARN, APPROXIMATE_ADDRESSES_ALLOW
    ));

    /** Default constructor for JSON deserialization. */
    public DeliveriesInfo() {}

    public DeliveriesInfo(String approximateAddresses, Map<String, String> properties) {
        this.approximateAddresses = approximateAddresses;
        this.properties = properties;
    }

    @Override
    public DeliveriesInfo clone() {
        return new DeliveriesInfo(approximateAddresses,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveriesInfo that = (DeliveriesInfo) o;
        return Objects.equals(approximateAddresses, that.approximateAddresses) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(approximateAddresses, properties);
    }

    /**
     * Policy for dealing with approximate addresses.
     * @see #ALL_APPROXIMATE_ADDRESSES
     */
    @JsonInclude(Include.NON_NULL)
    public String approximateAddresses = APPROXIMATE_ADDRESSES_DISALLOW;

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
