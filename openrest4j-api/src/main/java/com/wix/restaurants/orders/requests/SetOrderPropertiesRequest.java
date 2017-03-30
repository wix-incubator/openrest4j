package com.wix.restaurants.orders.requests;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.requests.Request;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetOrderPropertiesRequest extends Request {
	public static final String TYPE = "set_order_properties";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetOrderPropertiesRequest() {}
    
    public SetOrderPropertiesRequest(String accessToken, String orderId, Map<String, String> properties) {
    	this.accessToken = accessToken;
    	this.orderId = orderId;
    	this.properties = properties;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String orderId;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
}
