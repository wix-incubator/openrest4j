package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditcardsInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CreditcardsInfo() {}

    public CreditcardsInfo(Set<String> networks, Set<String> fields, String collectionMethod, LocalizedString comment) {
        this.networks = networks;
        this.fields = fields;
        this.collectionMethod = collectionMethod;
        this.comment = comment;
    }

    @Override
    public Object clone() {
        return new CreditcardsInfo(
                ((networks != null) ? new LinkedHashSet<>(networks) : null),
                ((fields != null) ? new LinkedHashSet<>(fields) : null),
                collectionMethod,
                (comment != null) ? (LocalizedString) comment.clone() : null);
    }

    /** Accepted networks, e.g. "visa", "mastercard", "amex". */
    @JsonInclude(Include.NON_NULL)
    public Set<String> networks = new LinkedHashSet<>();

    /** Required credit card fields, e.g. "csc", "holderId". */
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields = new LinkedHashSet<>();

    /**
     * Card collection method.
     * @see com.wix.restaurants.CollectionMethods
     */
    @JsonInclude(Include.NON_NULL)
    public String collectionMethod;

    /** Message to show when customer opts to pay by card. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString comment = LocalizedString.empty;
}
