package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when a new order is received. Blocking notification for POS push integrations. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosPushNotification extends Notification {
    public static final String TYPE = "pos_push";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public PosPushNotification() {}
    
    public PosPushNotification(String organizationId, String channelId, String channelParam, String comment, String state) {
    	super(organizationId, channelId, channelParam, comment, state);
    }
    
	@Override
	public Object clone() {
		return new PosPushNotification(organizationId, channelId, channelParam, comment, state);
	}
}
