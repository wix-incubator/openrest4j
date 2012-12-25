package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Base class for all Openrest objects.
 * @author DL
 */
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
	@Type(value = RestaurantFullInfo.class, name = RestaurantFullInfo.TYPE),
	@Type(value = ChainFullInfo.class, name = ChainFullInfo.TYPE),
	@Type(value = PortalFullInfo.class, name = PortalFullInfo.TYPE)
})
public abstract class OpenrestObject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OpenrestObject() {}
}
