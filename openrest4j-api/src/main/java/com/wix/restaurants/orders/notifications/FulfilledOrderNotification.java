package com.wix.restaurants.orders.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/** Triggered when an order is accepted. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FulfilledOrderNotification extends Notification {
    public static final String TYPE = "fulfilled_order";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public FulfilledOrderNotification() {}

    public FulfilledOrderNotification(String channelId, String channelParam, String comment, String state) {
        super(channelId, channelParam, comment, state);
    }

    @Override
    public FulfilledOrderNotification clone() {
        return new FulfilledOrderNotification(channelId, channelParam, comment, state);
    }
}
