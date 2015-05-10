package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditcardsInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CreditcardsInfo() {}

    public CreditcardsInfo(Set<String> networks, Set<String> fields) {
        this.networks = networks;
        this.fields = fields;
    }

    @Override
    public Object clone() {
        return new CreditcardsInfo(
                ((networks != null) ? new LinkedHashSet<>(networks) : null),
                ((fields != null) ? new LinkedHashSet<>(fields) : null));
    }

    /** Accepted networks, e.g. "visa", "mastercard", "amex". */
    @JsonInclude(Include.NON_NULL)
    public Set<String> networks = new LinkedHashSet<>();

    /** Required credit card fields, e.g. "csc", "holderId". */
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields = new LinkedHashSet<>();
}
