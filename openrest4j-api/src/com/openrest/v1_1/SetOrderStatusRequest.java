package com.openrest.v1_1;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String confirmationToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String orderId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String status;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String comment;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> externalIds = new HashMap<String, String>();
}
