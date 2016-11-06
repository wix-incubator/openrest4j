package com.wix.restaurants.reservations.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.notifications.Notification;

/** Triggered when a reservation is updated, or when a reservation update is not acknowledged for some time. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedReservationNotification extends Notification {
    public static final String TYPE = "updated_reservation";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public UpdatedReservationNotification() {}

    public UpdatedReservationNotification(String organizationId,
                                          String channelId,
                                          String channelParam,
                                          String comment,
                                          String state,
                                          Boolean autoAcknowledge,
                                          Integer durationMins) {
        super(organizationId, channelId, channelParam, comment, state);
        this.autoAcknowledge = autoAcknowledge;
        this.durationMins = durationMins;
    }

    @Override
    public Object clone() {
        return new UpdatedReservationNotification(organizationId, channelId, channelParam, comment, state, autoAcknowledge, durationMins);
    }

    /**
     * If true, the reservation update will be automatically marked as "acknowledged" upon successful transmission of
     * the notification.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean autoAcknowledge = Boolean.FALSE;

    /**
     * How long should the reservation update not be acknowledged for the notification to be triggered.
     * For example, 15 means "trigger the notification 15 minutes after an update is not acknowledged".
     *
     * A value of 0 means the notification should be triggered immediately on update.
     */
    @JsonInclude(Include.NON_NULL)
    public Integer durationMins;
}
