package com.wix.restaurants.orders.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.notifications.Notification;

/** Triggered when a new order is received. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrderNotification extends Notification {
    public static final String TYPE = "new_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public NewOrderNotification() {}
    
    public NewOrderNotification(String organizationId, String channelId, String channelParam, String comment, String state,
    		Boolean acceptOrder) {
    	super(organizationId, channelId, channelParam, comment, state);
    	this.acceptOrder = acceptOrder;
    }
    
	@Override
	public Object clone() {
		return new NewOrderNotification(organizationId, channelId, channelParam, comment, state, acceptOrder);
	}
	
    /**
     * For orders-related notifications, whether or not the order should be
     * marked as accepted upon successful transmission of the notification.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean acceptOrder = Boolean.FALSE;
}
