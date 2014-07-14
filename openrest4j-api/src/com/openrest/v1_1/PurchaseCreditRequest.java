package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseCreditRequest extends Request {
	public static final String TYPE = "purchase_credit";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public PurchaseCreditRequest() {}
    
    public PurchaseCreditRequest(String accessToken, String customerId, String supplierId, CurrencyAmount currencyAmount) {
    	this.accessToken = accessToken;
    	this.customerId = customerId;
    	this.supplierId = supplierId;
    	this.currencyAmount = currencyAmount;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String customerId;
    
    @JsonInclude(Include.NON_NULL)
    public String supplierId;
    
    @JsonInclude(Include.NON_NULL)
    public CurrencyAmount currencyAmount;
}
