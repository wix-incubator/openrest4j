package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBitpayPaymentRequest extends Request {
	public static final String TYPE = "create_bitpay_payment";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CreateBitpayPaymentRequest() {}
    
    public CreateBitpayPaymentRequest(String organizationId, String currency, Integer amount) {
    	this.organizationId = organizationId;
    	this.currency = currency;
    	this.amount = amount;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public String currency;
    
    @JsonInclude(Include.NON_NULL)
    public Integer amount;
}
