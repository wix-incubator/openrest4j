package com.openrest.v1_1;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String orderId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
}
