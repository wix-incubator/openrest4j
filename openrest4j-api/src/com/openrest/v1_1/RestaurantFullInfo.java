package com.openrest.v1_1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantFullInfo extends OpenrestObject {
	public static final String TYPE = "restaurant_full";
	
    private static final long serialVersionUID = 1L;
    
    public RestaurantFullInfo(Restaurant restaurant, Menu menu, List<Charge> charges,
    		Chain chain, Distributor distributor, Set<String> fbAdmins) {
    	this.restaurant = restaurant;
    	this.menu = menu;
    	this.charges = charges;
    	this.distributor = distributor;
    	this.chain = chain;
    	this.fbAdmins = fbAdmins;
    }
    
    /** Default constructor for JSON deserialization. */
    public RestaurantFullInfo() {}
    
    /** The restaurant. */
    @JsonInclude(Include.NON_NULL)
    public Restaurant restaurant;
    
    /** The menu. */
    @JsonInclude(Include.NON_NULL)
    public Menu menu;
    
    /** Use menu.charges (will be removed 2014-01-01) */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public List<Charge> charges;
    
    /** The distributor. */
    @JsonInclude(Include.NON_NULL)
    public Distributor distributor;
    
    /** The chain. */
    @JsonInclude(Include.NON_NULL)
    public Chain chain;
    
    /** The restaurant's Facebook admins. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> fbAdmins = new HashSet<String>();
}
