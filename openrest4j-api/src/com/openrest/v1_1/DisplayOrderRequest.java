package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Order order;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String locale;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Viewport viewport;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean embed = Boolean.FALSE;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean printHeader = Boolean.FALSE;
}
