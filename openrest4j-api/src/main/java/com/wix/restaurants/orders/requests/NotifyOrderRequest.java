package com.wix.restaurants.orders.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.requests.Request;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotifyOrderRequest extends Request {
	public static final String TYPE = "notify_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public NotifyOrderRequest() {}
    
    public NotifyOrderRequest(String accessToken, String orderId, String channelId, String channelParam, Locale locale,
    		String viewMode, Boolean anonymize, Boolean printHeader, Boolean printCsc) {
    	this.accessToken = accessToken;
    	this.orderId = orderId;
    	this.channelId = channelId;
    	this.channelParam = channelParam;
    	this.locale = locale;
    	this.viewMode = viewMode;
    	this.anonymize = anonymize;
    	this.printHeader = printHeader;
    	this.printCsc = printCsc;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String orderId;

    /** @see com.wix.restaurants.notifications.Channels */
    @JsonInclude(Include.NON_NULL)
    public String channelId;
    
    @JsonInclude(Include.NON_NULL)
    public String channelParam;
    
    @JsonInclude(Include.NON_NULL)
    public Locale locale;
    
    /** @see com.wix.restaurants.Actors */
    @JsonInclude(Include.NON_NULL)
    public String viewMode;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymize = Boolean.FALSE;

    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printHeader = Boolean.FALSE;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printCsc = Boolean.FALSE;
}
