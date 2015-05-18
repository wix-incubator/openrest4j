package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotifyOrderRequest extends Request {
	public static final String TYPE = "notify_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public NotifyOrderRequest() {}
    
    public NotifyOrderRequest(String accessToken, String orderId, String channelId, String channelParam, String locale, 
    		String viewMode, Boolean anonymize, Boolean printConfirmation, Boolean printHeader, Boolean printCsc) {
    	this.accessToken = accessToken;
    	this.orderId = orderId;
    	this.channelId = channelId;
    	this.channelParam = channelParam;
    	this.locale = locale;
    	this.viewMode = viewMode;
    	this.anonymize = anonymize;
    	this.printConfirmation = printConfirmation;
    	this.printHeader = printHeader;
    	this.printCsc = printCsc;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String orderId;
    
    @JsonInclude(Include.NON_NULL)
    public String channelId;
    
    @JsonInclude(Include.NON_NULL)
    public String channelParam;
    
    @JsonInclude(Include.NON_NULL)
    public String locale;
    
    /** @see Order#ALL_ORDER_VIEW_MODES */
    @JsonInclude(Include.NON_NULL)
    public String viewMode;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymize = Boolean.FALSE;

    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printConfirmation = Boolean.FALSE;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printHeader = Boolean.FALSE;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printCsc = Boolean.FALSE;
}
