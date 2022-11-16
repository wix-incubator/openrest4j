package com.wix.restaurants.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when a restaurants Location settings are changed in settings V3 in some way. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationSettingsUpdatedNotification extends Notification {
    public static final String TYPE = "location_settings_updated";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public LocationSettingsUpdatedNotification() {}

    public LocationSettingsUpdatedNotification(String channelId, String channelParam, String comment, String state) {
        super(channelId, channelParam, comment, state);
    }

    @Override
    public LocationSettingsUpdatedNotification clone() {
        return new LocationSettingsUpdatedNotification(channelId, channelParam, comment, state);
    }
}
