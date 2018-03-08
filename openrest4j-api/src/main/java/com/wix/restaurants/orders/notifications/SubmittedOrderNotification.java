package com.wix.restaurants.orders.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.notifications.Notification;

import java.util.Objects;

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
	public SubmittedOrderNotification clone() {
		return new SubmittedOrderNotification(organizationId, channelId, channelParam, comment, state, acceptOrder);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SubmittedOrderNotification that = (SubmittedOrderNotification) o;
        return Objects.equals(acceptOrder, that.acceptOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), acceptOrder);
    }

    /**
     * For orders-related notifications, whether or not the order should be
     * marked as accepted upon successful transmission of the notification.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean acceptOrder = Boolean.FALSE;
}
