package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/**
 * Triggered when a new user subscribes to the organization's mailing list.
 * Deprecated on 2018-08-01.
 */
@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionNotification extends Notification {
    public static final String TYPE = "subscription";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SubscriptionNotification() {}
    
    public SubscriptionNotification(String channelId, String channelParam, String comment, String state) {
    	super(channelId, channelParam, comment, state);
    }
    
	@Override
	public SubscriptionNotification clone() {
		return new SubscriptionNotification(channelId, channelParam, comment, state);
	}
}
