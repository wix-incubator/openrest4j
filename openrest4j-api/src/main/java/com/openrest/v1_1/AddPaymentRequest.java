package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.payments.CreditcardPayment;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddPaymentRequest extends Request {
	public static final String TYPE = "add_payment";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AddPaymentRequest() {}
    
    public AddPaymentRequest(String accessToken, ClientId clientId, CreditcardPayment payment) {
    	this.accessToken = accessToken;
    	this.clientId = clientId;
    	this.payment = payment;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;
    
    @JsonInclude(Include.NON_NULL)
    public CreditcardPayment payment;
}
