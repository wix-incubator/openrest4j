package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitOrderRequest extends Request {
	public static final String TYPE = "submit_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SubmitOrderRequest() {}
    
    public SubmitOrderRequest(String accessToken, Order order, String comment) {
    	this.accessToken = accessToken;
    	this.order = order;
    	this.comment = comment;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Order order;
    
    /** Technical comment (NOT user comment!) */
    @JsonInclude(Include.NON_NULL)
    public String comment;
}
