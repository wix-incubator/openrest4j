package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderConfirmation implements Serializable {
    public OrderConfirmation(Order order, LocalizedString message) {
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
    public LocalizedString message = LocalizedString.empty;
    
    private static final long serialVersionUID = 1L;
}
