package com.wix.restaurants.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when an organization is changed in some way. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedSettingsNotification extends Notification {
    public static final String TYPE = "updated_settings";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public UpdatedSettingsNotification() {}

    public UpdatedSettingsNotification(String channelId, String channelParam, String comment, String state) {
        super(channelId, channelParam, comment, state);
    }

    @Override
    public UpdatedSettingsNotification clone() {
        return new UpdatedSettingsNotification(channelId, channelParam, comment, state);
    }
}
