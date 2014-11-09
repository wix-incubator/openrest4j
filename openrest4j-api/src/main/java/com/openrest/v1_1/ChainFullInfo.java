package com.openrest.v1_1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChainFullInfo extends OpenrestObject {
	public static final String TYPE = "chain_full";
	
    private static final long serialVersionUID = 1L;
    
    public ChainFullInfo(Chain chain, Distributor distributor, List<? extends Restaurant> restaurants) {
    	this.chain = chain;
    	this.distributor = distributor;
    	this.restaurants = restaurants;
    }
    
    /** Default constructor for JSON deserialization. */
    public ChainFullInfo() {}
    
    /** The chain. */
    @JsonInclude(Include.NON_NULL)
    public Chain chain;
    
    /** The distributor. */
    @JsonInclude(Include.NON_NULL)
    public Distributor distributor;
    
    /** The restaurants. */
    @JsonInclude(Include.NON_NULL)
    public List<? extends Restaurant> restaurants;
}
