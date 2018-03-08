package com.wix.restaurants.orders.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/** Triggered on POS errors, e.g. POS is down. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosErrorNotification extends Notification {
    public static final String TYPE = "pos_error";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public PosErrorNotification() {}
    
    public PosErrorNotification(String organizationId, String channelId, String channelParam, String comment, String state) {
    	super(organizationId, channelId, channelParam, comment, state);
    }
    
	@Override
	public PosErrorNotification clone() {
		return new PosErrorNotification(organizationId, channelId, channelParam, comment, state);
	}
}
