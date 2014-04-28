package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AffiliateFullInfo extends OpenrestObject {
	public static final String TYPE = "affiliate_full";
	
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AffiliateFullInfo() {}
    
    public AffiliateFullInfo(Affiliate affiliate, Distributor distributor) {
    	this.affiliate = affiliate;
    	this.distributor = distributor;
    }
    
    /** The affiliate. */
    @JsonInclude(Include.NON_NULL)
    public Affiliate affiliate;
    
    /** The distributor. */
    @JsonInclude(Include.NON_NULL)
    public Distributor distributor;
}
