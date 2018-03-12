package com.wix.restaurants.reservations.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/** Triggered when a reservation is created, or updated by another actor. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedReservationNotification extends Notification {
    public static final String TYPE = "updated_reservation";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public UpdatedReservationNotification() {}

    public UpdatedReservationNotification(String channelId,
                                          String channelParam,
                                          String comment,
                                          String state) {
        super(channelId, channelParam, comment, state);
    }

    @Override
    public UpdatedReservationNotification clone() {
        return new UpdatedReservationNotification(channelId, channelParam, comment, state);
    }
}
