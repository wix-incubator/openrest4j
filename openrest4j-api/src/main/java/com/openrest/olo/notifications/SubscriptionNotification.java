package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/** Triggered when a new user subscribes to the organization's mailing list. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionNotification extends Notification {
    public static final String TYPE = "subscription";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SubscriptionNotification() {}
    
    public SubscriptionNotification(String organizationId, String channelId, String channelParam, String comment, String state) {
    	super(organizationId, channelId, channelParam, comment, state);
    }
    
	@Override
	public Object clone() {
		return new SubscriptionNotification(organizationId, channelId, channelParam, comment, state);
	}
}
