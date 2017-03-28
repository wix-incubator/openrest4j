package com.wix.restaurants.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.openrest.olo.notifications.FeedbackNotification;
import com.openrest.olo.notifications.OfflineNotification;
import com.openrest.olo.notifications.SubscriptionNotification;
import com.openrest.v1_1.Channel;
import com.openrest.v1_1.State;
import com.wix.restaurants.olo.notifications.*;
import com.wix.restaurants.reservations.notifications.UpdatedReservationNotification;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "type")  
@JsonSubTypes({
	@Type(value = NewOrderNotification.class, name = NewOrderNotification.TYPE),
	@Type(value = SubmittedOrderNotification.class, name = SubmittedOrderNotification.TYPE),
	@Type(value = DelayedOrderNotification.class, name = DelayedOrderNotification.TYPE),
	@Type(value = AcceptedOrderNotification.class, name = AcceptedOrderNotification.TYPE),
	@Type(value = CanceledOrderNotification.class, name = CanceledOrderNotification.TYPE),
	@Type(value = OfflineNotification.class, name = OfflineNotification.TYPE),
	@Type(value = PosErrorNotification.class, name = PosErrorNotification.TYPE),
	@Type(value = FeedbackNotification.class, name = FeedbackNotification.TYPE),
	@Type(value = SubscriptionNotification.class, name = SubscriptionNotification.TYPE),
	@Type(value = LowStockNotification.class, name = LowStockNotification.TYPE),
	@Type(value = UpdatedReservationNotification.class, name = UpdatedReservationNotification.TYPE),
})
public abstract class Notification implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public Notification() {}
    
    public Notification(String organizationId, String channelId, String channelParam, String comment, String state) {
    	this.organizationId = organizationId;
    	this.channelId = channelId;
    	this.channelParam = channelParam;
    	this.comment = comment;
    	this.state = state;
    }
    
    @Override
	public abstract Object clone();
    
	public static List<Notification> clone(List<Notification> notifications) {
		if (notifications == null) {
			return null;
		}
		
    	final List<Notification> cloned = new LinkedList<>();
    	for (Notification notification : notifications) {
    		cloned.add((notification != null) ? (Notification) notification.clone() : null);
    	}
    	return cloned;
	}
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;    

    /** @see Channels */
    @JsonInclude(Include.NON_NULL)
    public String channelId;
    
    /** @see Channel */
    @JsonInclude(Include.NON_NULL)
    public String channelParam;
    
    /** Free-text comment, e.g. who is notified. */
    @JsonInclude(Include.NON_NULL)
    public String comment;
    
    /** @see State#ALL_STATES */
    @JsonInclude(Include.NON_DEFAULT)
    public String state = State.STATE_OPERATIONAL;
}
