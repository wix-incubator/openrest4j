package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBalanceLinesRequest extends Request {
	public static final String TYPE = "get_balance_lines";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetBalanceLinesRequest() {}
    
    public GetBalanceLinesRequest(String accessToken, String customerId, String supplierId, Date since, Date until) {
    	this.accessToken = accessToken;
    	this.customerId = customerId;
    	this.supplierId = supplierId;
    	this.since = since;
    	this.until = until;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    /** The customer-id (null means any). */
    @JsonInclude(Include.NON_NULL)
    public String customerId;
    
    /** The supplier-id (null means any). */
    @JsonInclude(Include.NON_NULL)
    public String supplierId;
    
    /** Corresponds to BalanceLine.forDate, inclusive (null to ignore). */
    @JsonInclude(Include.NON_NULL)
    public Date since;
    
    /** Corresponds to BalanceLine.forDate, exclusive (null to ignore). */
    @JsonInclude(Include.NON_NULL)
    public Date until;
}
