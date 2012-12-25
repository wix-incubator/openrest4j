package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Portal portal;
    
    /** The distributor. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Distributor distributor;
}
