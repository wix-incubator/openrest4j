package com.wix.restaurants.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/** Triggered when a new feedback is received. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LowStockNotification extends Notification {
    public static final String TYPE = "low_stock";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public LowStockNotification() {}
    
    public LowStockNotification(String organizationId, String channelId, String channelParam, String comment, String state) {
    	super(organizationId, channelId, channelParam, comment, state);
    }
    
	@Override
	public Object clone() {
		return new LowStockNotification(organizationId, channelId, channelParam, comment, state);
	}
}
