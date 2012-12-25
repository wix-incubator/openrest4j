package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderConfirmation implements Serializable {
    public OrderConfirmation(Order order, Map<String, String> message) {
        this.order = order;
        this.message = message;
    }
    
    /** Default constructor for JSON deserialization. */
    public OrderConfirmation() {}

    /** The confirmed order. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Order order;

    /** The restaurant's confirmation message in various locales. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> message = Collections.emptyMap();
    
    private static final long serialVersionUID = 1L;
}
