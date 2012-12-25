package com.openrest.v1_1;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrderRequest extends Request {
	public static final String TYPE = "get_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrderRequest() {}
    
    public GetOrderRequest(String accessToken, String orderId, Boolean restaurantView, String shareToken,
    		Boolean anonymize, Set<String> fields, String locale, Viewport viewport, Boolean embed,
    		Boolean printConfirmation, Boolean printHeader) {
    	this.accessToken = accessToken;
    	this.orderId = orderId;
    	this.restaurantView = restaurantView;
    	this.shareToken = shareToken;
    	this.anonymize = anonymize;
    	this.fields = fields;
    	this.locale = locale;
    	this.viewport = viewport;
    	this.embed = embed;
    	this.printConfirmation = printConfirmation;
    	this.printHeader = printHeader;
    }
    
    public GetOrderRequest(String accessToken, String orderId, Boolean restaurantView, String shareToken,
    		Boolean anonymize, Set<String> fields) {
    	this(accessToken, orderId, restaurantView, shareToken, anonymize, fields, shareToken,
    			null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String orderId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean restaurantView = Boolean.FALSE;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String shareToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean anonymize = Boolean.FALSE;
    
    /** For Order.html, if null Order.locale will be used. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public String locale;
    
    /** For Order.html. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Viewport viewport;
    
    /** For Order.html. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean embed = Boolean.FALSE;
    
    /** For Order.html. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean printConfirmation = Boolean.FALSE;
    
    /** For Order.html. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean printHeader = Boolean.FALSE;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public Set<String> fields;
}
