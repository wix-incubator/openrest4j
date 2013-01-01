package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PortalFullInfo extends OpenrestObject {
	public static final String TYPE = "portal_full";
	
    private static final long serialVersionUID = 1L;
    
    public PortalFullInfo(Portal portal, Distributor distributor) {
    	this.portal = portal;
    	this.distributor = distributor;
    }
    
    /** Default constructor for JSON deserialization. */
    public PortalFullInfo() {}
    
    /** The portal. */
    @JsonInclude(Include.NON_NULL)
    public Portal portal;
    
    /** The distributor. */
    @JsonInclude(Include.NON_NULL)
    public Distributor distributor;
}
