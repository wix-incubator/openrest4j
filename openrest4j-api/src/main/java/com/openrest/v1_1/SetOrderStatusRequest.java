package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetOrderStatusRequest extends Request {
	public static final String TYPE = "set_order_status";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetOrderStatusRequest() {}
    
    public SetOrderStatusRequest(String accessToken, String confirmationToken, String orderId, String status, String comment,
    		Map<String, String> externalIds) {
    	this.accessToken = accessToken;
    	this.confirmationToken = confirmationToken;
    	this.orderId = orderId;
    	this.status = status;
    	this.comment = comment;
    	this.externalIds = externalIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String confirmationToken;
    
    @JsonInclude(Include.NON_NULL)
    public String orderId;
    
    /**
     * @see com.wix.restaurants.olo.Statuses
     * null means "no change" (for comment only statuses)
     */
    @JsonInclude(Include.NON_NULL)
    public String status;
    
    @JsonInclude(Include.NON_NULL)
    public String comment;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<>();
}
