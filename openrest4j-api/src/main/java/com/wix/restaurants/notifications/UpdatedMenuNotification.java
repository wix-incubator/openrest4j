package com.wix.restaurants.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when an organization is changed in some way. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedMenuNotification extends Notification {
    public static final String TYPE = "updated_menu";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public UpdatedMenuNotification() {}

    public UpdatedMenuNotification(String channelId, String channelParam, String comment, String state) {
        super(channelId, channelParam, comment, state);
    }

    @Override
    public UpdatedMenuNotification clone() {
        return new UpdatedMenuNotification(channelId, channelParam, comment, state);
    }
}
