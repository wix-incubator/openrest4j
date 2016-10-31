package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrderRequest extends Request {
	public static final String TYPE = "get_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrderRequest() {}
    
    public GetOrderRequest(String accessToken, String shareToken, String ownerToken,
                           String orderId, String viewMode, Boolean anonymize,
                           Set<String> fields, String locale, Viewport viewport, Boolean embed,
                           Boolean printHeader, Boolean printCsc) {
    	this.accessToken = accessToken;
        this.shareToken = shareToken;
        this.ownerToken = ownerToken;
    	this.orderId = orderId;
    	this.viewMode = viewMode;
    	this.anonymize = anonymize;
    	this.fields = fields;
    	this.locale = locale;
    	this.viewport = viewport;
    	this.embed = embed;
    	this.printHeader = printHeader;
    	this.printCsc = printCsc;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** @see Order#shareToken */
    @JsonInclude(Include.NON_NULL)
    public String shareToken;

    /** @see Order#ownerToken */
    @JsonInclude(Include.NON_NULL)
    public String ownerToken;

    @JsonInclude(Include.NON_NULL)
    public String orderId;
    
    /** @see com.wix.restaurants.Actors */
    @JsonInclude(Include.NON_NULL)
    public String viewMode;
    
    /** Use viewMode */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean restaurantView = Boolean.FALSE;

    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymize = Boolean.FALSE;
    
    /** For Order.html, if null Order.locale will be used. */
    @JsonInclude(Include.NON_NULL)
	public String locale;
    
    /** For Order.html. */
    @JsonInclude(Include.NON_NULL)
    public Viewport viewport;
    
    /** For Order.html. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean embed = Boolean.FALSE;
    
    /** For Order.html. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printHeader = Boolean.FALSE;
    
    /** For Order.html. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printCsc = Boolean.FALSE;
    
    @JsonInclude(Include.NON_NULL)
	public Set<String> fields;
}
