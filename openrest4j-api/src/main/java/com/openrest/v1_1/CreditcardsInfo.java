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
    public CreditcardsInfo clone() {
        return new CreditcardsInfo(
                ((networks != null) ? new LinkedHashSet<>(networks) : null),
                ((fields != null) ? new LinkedHashSet<>(fields) : null),
                collectionMethod,
                (comment != null) ? comment.clone() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditcardsInfo that = (CreditcardsInfo) o;

        if (networks != null ? !networks.equals(that.networks) : that.networks != null) return false;
        if (fields != null ? !fields.equals(that.fields) : that.fields != null) return false;
        if (collectionMethod != null ? !collectionMethod.equals(that.collectionMethod) : that.collectionMethod != null) return false;
        return comment != null ? comment.equals(that.comment) : that.comment == null;
    }

    @Override
    public int hashCode() {
        int result = networks != null ? networks.hashCode() : 0;
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        result = 31 * result + (collectionMethod != null ? collectionMethod.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
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
