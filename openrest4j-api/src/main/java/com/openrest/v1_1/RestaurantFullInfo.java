package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantFullInfo extends OpenrestObject {
	public static final String TYPE = "restaurant_full";
	
    private static final long serialVersionUID = 1L;
    
    public RestaurantFullInfo(Restaurant restaurant, Menu menu, List<Charge> charges, Chain chain, Distributor distributor) {
    	this.restaurant = restaurant;
    	this.menu = menu;
    	this.charges = charges;
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
    
    /** Scheduled for deprecation on 2014-01-01 (use menu.charges) */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public List<Charge> charges;
    
    /** The distributor. */
    @JsonInclude(Include.NON_NULL)
    public Distributor distributor;
    
    /** The chain. */
    @JsonInclude(Include.NON_NULL)
    public Chain chain;
}
