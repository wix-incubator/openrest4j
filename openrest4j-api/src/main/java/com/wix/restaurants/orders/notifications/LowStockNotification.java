package com.wix.restaurants.orders.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/** Triggered when a new feedback is received. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LowStockNotification extends Notification {
    public static final String TYPE = "low_stock";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public LowStockNotification() {}
    
    public LowStockNotification(String channelId, String channelParam, String comment, String state) {
    	super(channelId, channelParam, comment, state);
    }
    
	@Override
	public LowStockNotification clone() {
		return new LowStockNotification(channelId, channelParam, comment, state);
	}
}
