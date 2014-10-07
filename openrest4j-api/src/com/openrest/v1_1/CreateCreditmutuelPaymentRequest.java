package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCreditmutuelPaymentRequest extends Request {
	public static final String TYPE = "create_creditmutuel_payment";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CreateCreditmutuelPaymentRequest() {}
    
    public CreateCreditmutuelPaymentRequest(String organizationId, Contact contact, CurrencyAmount currencyAmount) {
    	this.organizationId = organizationId;
    	this.contact = contact;
    	this.currencyAmount = currencyAmount;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Contact contact;
    
    @JsonInclude(Include.NON_NULL)
    public CurrencyAmount currencyAmount;
}
