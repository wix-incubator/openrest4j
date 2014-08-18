package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when an order is accepted. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AcceptedOrderNotification extends Notification {
    public static final String TYPE = "accepted_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AcceptedOrderNotification() {}
    
    public AcceptedOrderNotification(String organizationId, String channelId, String channelParam, String comment, String state) {
    	super(organizationId, channelId, channelParam, comment, state);
    }
    
	@Override
	public Object clone() {
		return new AcceptedOrderNotification(organizationId, channelId, channelParam, comment, state);
	}
}
