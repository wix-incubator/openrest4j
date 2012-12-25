package com.openrest.v1_1;

import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantFullInfo extends OpenrestObject {
	public static final String TYPE = "restaurant_full";
	
    private static final long serialVersionUID = 1L;
    
    public RestaurantFullInfo(Restaurant restaurant, Menu menu, List<Charge> charges,
    		Chain chain, Distributor distributor, List<String> fbAdmins) {
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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Restaurant restaurant;
    
    /** The menu. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Menu menu;
    
    /** The charges. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public List<Charge> charges;
    
    /** The distributor. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Distributor distributor;
    
    /** The chain. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Chain chain;
    
    /** The restaurant's Facebook admins. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<String> fbAdmins = Collections.emptyList();
}
