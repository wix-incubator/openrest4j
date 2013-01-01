package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayOrderRequest extends Request {
	public static final String TYPE = "display_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public DisplayOrderRequest() {}
    
    public DisplayOrderRequest(String accessToken, Order order, String locale, Viewport viewport,
    		Boolean embed, Boolean printHeader) {
    	this.accessToken = accessToken;
    	this.order = order;
    	this.locale = locale;
    	this.viewport = viewport;
    	this.embed = embed;
    	this.printHeader = printHeader;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Order order;
    
    @JsonInclude(Include.NON_NULL)
    public String locale;
    
    @JsonInclude(Include.NON_NULL)
    public Viewport viewport;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean embed = Boolean.FALSE;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printHeader = Boolean.FALSE;
}
