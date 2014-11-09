package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Base class for all OpenRest objects. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "type")  
@JsonSubTypes({
	@Type(value = Restaurant.class, name = Restaurant.TYPE),
	@Type(value = Chain.class, name = Chain.TYPE),
	@Type(value = Distributor.class, name = Distributor.TYPE),
	@Type(value = Portal.class, name = Portal.TYPE),
	@Type(value = Affiliate.class, name = Affiliate.TYPE),
	@Type(value = RestaurantFullInfo.class, name = RestaurantFullInfo.TYPE),
	@Type(value = ChainFullInfo.class, name = ChainFullInfo.TYPE),
	@Type(value = PortalFullInfo.class, name = PortalFullInfo.TYPE),
	@Type(value = AffiliateFullInfo.class, name = AffiliateFullInfo.TYPE)
})
public abstract class OpenrestObject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OpenrestObject() {}
}
