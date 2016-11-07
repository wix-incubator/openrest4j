package com.wix.restaurants.reservations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Request;
import com.wix.restaurants.reservations.Reservation;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitReservationRequest extends Request {
    public static final String TYPE = "submit_reservation";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SubmitReservationRequest() {}

    public SubmitReservationRequest(String accessToken, Reservation reservation) {
        this.accessToken = accessToken;
        this.reservation = reservation;
    }

    /** Optional access token of the user submitting the reservation. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String accessToken;

    /** The reservation. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Reservation reservation;
}
