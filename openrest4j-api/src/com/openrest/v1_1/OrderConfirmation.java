package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderConfirmation implements Serializable {
    public OrderConfirmation(Order order, Map<String, String> message) {
        this.order = order;
        this.message = message;
    }
    
    /** Default constructor for JSON deserialization. */
    public OrderConfirmation() {}

    /** The confirmed order. */
    @JsonInclude(Include.NON_NULL)
    public Order order;

    /** The restaurant's confirmation message in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> message = new HashMap<String, String>();
    
    private static final long serialVersionUID = 1L;
}
