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
    private static final long serialVersionUID = 1L;
    
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
    public Notification(String organizationId, String type, String channelId, String channelParam,
    		Integer durationMins, Boolean acceptOrder, String comment, String state) {
        this.organizationId = organizationId;
        this.type = type;
        this.channelId = channelId;
        this.channelParam = channelParam;
        this.durationMins = durationMins;
        this.acceptOrder = acceptOrder;
        this.comment = comment;
        this.state = state;
    }

    /** Default constructor for JSON deserialization. */
    public Notification() {}
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;    

    /** Notification type. */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** @see Channel.ALL_CHANNELS */
    @JsonInclude(Include.NON_NULL)
    public String channelId;
    
    /** @see Channel */
    @JsonInclude(Include.NON_NULL)
    public String channelParam;

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
    
    /** Free-text comment, e.g. who is notified. */
    @JsonInclude(Include.NON_NULL)
    public String comment;
    
    /** @see State.ALL_STATES */
    @JsonInclude(Include.NON_DEFAULT)
    public String state = State.STATE_OPERATIONAL;
    
    @Override
	public String toString() {
		return "Notification [organizationId=" + organizationId + ", type=" + type
				+ ", channelId=" + channelId + ", channelParam=" + channelParam
				+ ", durationMins=" + durationMins + ", acceptOrder=" + acceptOrder
				+ ", comment=" + comment + ", state=" + state + "]";
	}
}
