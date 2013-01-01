package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeletePaymentRequest extends Request {
	public static final String TYPE = "delete_payment";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public DeletePaymentRequest() {}
    
    public DeletePaymentRequest(String accessToken, String paymentId) {
    	this.accessToken = accessToken;
    	this.paymentId = paymentId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String paymentId;
}
