package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Triggered when a new order is submitted to the restaurant. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmittedOrderNotification extends Notification {
    public static final String TYPE = "submitted_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SubmittedOrderNotification() {}
    
    public SubmittedOrderNotification(String organizationId, String channelId, String channelParam, String comment, String state,
    		Boolean acceptOrder) {
    	super(organizationId, channelId, channelParam, comment, state);
    	this.acceptOrder = acceptOrder;
    }
    
	@Override
	public Object clone() {
		return new SubmittedOrderNotification(organizationId, channelId, channelParam, comment, state, acceptOrder);
	}
	
    /**
     * For orders-related notifications, whether or not the order should be
     * marked as accepted upon successful transmission of the notification.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean acceptOrder = Boolean.FALSE;
}
