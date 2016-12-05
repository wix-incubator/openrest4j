package com.wix.restaurants.reservations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Request;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfirmReservationRequest extends Request {
    public static final String TYPE = "confirm_reservation";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ConfirmReservationRequest() {}

    public ConfirmReservationRequest(String reservationId, String confirmationToken) {
        this.reservationId = reservationId;
        this.confirmationToken = confirmationToken;
    }

    /** The reservation's unique identifier. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String reservationId;

    /** Confirmation token sent by SMS to customer. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String confirmationToken;
}
