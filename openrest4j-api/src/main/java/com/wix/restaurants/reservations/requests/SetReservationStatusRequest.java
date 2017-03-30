package com.wix.restaurants.reservations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Request;
import com.wix.restaurants.reservations.Reservation;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetReservationStatusRequest extends Request {
    public static final String TYPE = "set_reservation_status";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SetReservationStatusRequest() {}

    public SetReservationStatusRequest(String accessToken, String ownerToken, String actingAs,
                                       String reservationId, String status, String comment) {
        this.accessToken = accessToken;
        this.ownerToken = ownerToken;
        this.actingAs = actingAs;
        this.reservationId = reservationId;
        this.status = status;
        this.comment = comment;
    }

    /** User access token (null if using ownerToken). */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String accessToken;

    /**
     * Owner token for modifying the reservation as owner (null if using accessToken).
     * @see Reservation#ownerToken
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String ownerToken;

    /** @see com.wix.restaurants.Actors */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String actingAs;

    /** The reservation's unique identifier. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String reservationId;

    /**
     * @see com.wix.restaurants.reservations.Statuses
     * null means "no change" (for comment only statuses)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String status;

    /** Optional comment. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String comment;
}
