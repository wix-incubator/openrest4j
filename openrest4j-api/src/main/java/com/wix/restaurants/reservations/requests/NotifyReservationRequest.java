package com.wix.restaurants.reservations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.requests.Request;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotifyReservationRequest extends Request {
    public static final String TYPE = "notify_reservation";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public NotifyReservationRequest() {}

    public NotifyReservationRequest(String accessToken, String reservationId, String channelId, String channelParam,
                                    Locale locale, String viewMode) {
        this.accessToken = accessToken;
        this.reservationId = reservationId;
        this.channelId = channelId;
        this.channelParam = channelParam;
        this.locale = locale;
        this.viewMode = viewMode;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** The reservation's unique identifier. */
    @JsonInclude(Include.NON_NULL)
    public String reservationId;

    /** @see com.wix.restaurants.notifications.Channels */
    @JsonInclude(Include.NON_NULL)
    public String channelId;

    /** @see com.wix.restaurants.notifications.Channels */
    @JsonInclude(Include.NON_NULL)
    public String channelParam;

    /** The requested locale. */
    @JsonInclude(Include.NON_NULL)
    public Locale locale;

    /** @see com.wix.restaurants.Actors */
    @JsonInclude(Include.NON_NULL)
    public String viewMode;
}
