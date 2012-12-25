package com.openrest.v1_1;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Chain chain;
    
    /** The distributor. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Distributor distributor;
    
    /** The restaurants. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public List<? extends Restaurant> restaurants;
}
