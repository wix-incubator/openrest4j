package com.wix.restaurants.orders.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/** Triggered when an order is changed in some way. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedOrderNotification extends Notification {
    public static final String TYPE = "updated_order";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public UpdatedOrderNotification() {}

    public UpdatedOrderNotification(String channelId, String channelParam, String comment, String state) {
        super(channelId, channelParam, comment, state);
    }

    @Override
    public UpdatedOrderNotification clone() {
        return new UpdatedOrderNotification(channelId, channelParam, comment, state);
    }
}
