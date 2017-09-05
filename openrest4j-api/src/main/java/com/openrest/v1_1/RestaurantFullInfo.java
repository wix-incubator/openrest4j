package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantFullInfo extends OpenrestObject {
	public static final String TYPE = "restaurant_full";
	
    private static final long serialVersionUID = 1L;
    
    public RestaurantFullInfo(Restaurant restaurant, Menu menu, Chain chain, Distributor distributor) {
    	this.restaurant = restaurant;
    	this.menu = menu;
    	this.distributor = distributor;
    	this.chain = chain;
    }
    
    /** Default constructor for JSON deserialization. */
    public RestaurantFullInfo() {}
    
    /** The restaurant. */
    @JsonInclude(Include.NON_NULL)
    public Restaurant restaurant;
    
    /** The menu. */
    @JsonInclude(Include.NON_NULL)
    public Menu menu;

    /** The distributor. */
    @JsonInclude(Include.NON_NULL)
    public Distributor distributor;
    
    /** The chain. */
    @JsonInclude(Include.NON_NULL)
    public Chain chain;
}
