package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification implements Serializable {
    /** Triggered when a new order is received. Duration is always 0. */
    public static final String NOTIFICATION_TYPE_NEW_ORDER = "new_order";
    /** Triggered when a new order is not handled for some duration. */
    public static final String NOTIFICATION_TYPE_DELAYED_ORDER = "delayed_order";
    /** Triggered when an order is canceled. Duration is always 0. */
    public static final String NOTIFICATION_TYPE_CANCELED_ORDER = "canceled_order";
    /** Triggered when no one checks for existence of new orders for some duration. */
    public static final String NOTIFICATION_TYPE_OFFLINE = "offline";
    /** Triggered on POS errors, e.g. POS is down. */
    public static final String NOTIFICATION_TYPE_POS_ERROR = "pos_error";
    /** Triggered when a new feedback is received. Duration is always 0. */
    public static final String NOTIFICATION_TYPE_FEEDBACK = "feedback";

    /** All known notification types. */
    public static final Set<String> ALL_NOTIFICATION_TYPES = new HashSet<String>(Arrays.asList(
    		NOTIFICATION_TYPE_NEW_ORDER, NOTIFICATION_TYPE_DELAYED_ORDER, NOTIFICATION_TYPE_CANCELED_ORDER,
    		NOTIFICATION_TYPE_OFFLINE, NOTIFICATION_TYPE_POS_ERROR, NOTIFICATION_TYPE_FEEDBACK
    ));

    /** Constructs a previously submitted notification from persisted data. */
    public Notification(String restaurantId, String type, Contact contact,
    		Integer durationMins, Boolean acceptOrder) {
        this.restaurantId = restaurantId;
        this.type = type;
        this.contact = contact;
        this.durationMins = durationMins;
        this.acceptOrder = acceptOrder;
    }

    /** Constructs a new notification to be submitted. */
    public Notification(String type, Contact contact, Integer durationMins, Boolean acceptOrder) {
        this(null, type, contact, durationMins, acceptOrder);
    }
    
    /** Default constructor for JSON deserialization. */
    public Notification() {}

    public Notification delayedOrderNotification(Contact contact, Integer durationMins, Boolean acceptOrder) {
        return new Notification(NOTIFICATION_TYPE_DELAYED_ORDER, contact, durationMins, acceptOrder);
    }

    @JsonInclude(Include.NON_NULL)
    public String restaurantId;

    /** Notification type. */
    @JsonInclude(Include.NON_NULL)
    public String type;

    /** Who should be notified. */
    @JsonInclude(Include.NON_NULL)
    public Contact contact;

    /**
     * Event duration for triggering a notification, e.g. "after 15 minutes of
     * not handling an incoming order".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer durationMins = 0;
    
    /**
     * For orders-related notifications, whether or not the order should be
     * marked as accepted upon successful transmission of the notification.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean acceptOrder = Boolean.FALSE;
    
    @Override
	public String toString() {
		return "Notification [restaurantId=" + restaurantId + ", type=" + type
				+ ", contact=" + contact + ", durationMins=" + durationMins
				+ ", acceptOrder=" + acceptOrder + "]";
	}

    private static final long serialVersionUID = 1L;
}
