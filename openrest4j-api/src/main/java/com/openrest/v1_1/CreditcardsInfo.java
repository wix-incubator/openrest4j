package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditcardsInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /**
     * Credit card information is collected at the time of delivery.
     * @see <a href="http://en.wikipedia.org/wiki/Cash_on_delivery">Cash on delivery</a>
     */
    public static final String COLLECTION_METHOD_COD = "cod";
    /** Credit card information is collected over phone (the restaurant calls the customer). */
    public static final String COLLECTION_METHOD_PHONE = "phone";
    /** Credit card information is collected online. */
    public static final String COLLECTION_METHOD_ONLINE = "online";

    public static final Set<String> ALL_COLLECTION_METHODS = new HashSet<>(Arrays.asList(
            COLLECTION_METHOD_COD, COLLECTION_METHOD_PHONE, COLLECTION_METHOD_ONLINE
    ));

    /** Default constructor for JSON deserialization. */
    public CreditcardsInfo() {}

    public CreditcardsInfo(Set<String> networks, Set<String> fields, String collectionMethod, Map<String, String> comment) {
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
                ((comment != null) ? new LinkedHashMap<>(comment) : null));
    }

    /** Accepted networks, e.g. "visa", "mastercard", "amex". */
    @JsonInclude(Include.NON_NULL)
    public Set<String> networks = new LinkedHashSet<>();

    /** Required credit card fields, e.g. "csc", "holderId". */
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields = new LinkedHashSet<>();

    /**
     * Credit card collection method.
     * @see #ALL_COLLECTION_METHODS
     */
    @JsonInclude(Include.NON_NULL)
    public String collectionMethod;

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> comment = new LinkedHashMap<>();
}
