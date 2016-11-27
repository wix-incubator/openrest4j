package com.wix.restaurants.reservations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.List;

public class ReservationsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ReservationsResponse() {}

    public ReservationsResponse(List<Reservation> results) {
        this.results = results;
    }

    @JsonInclude(Include.NON_NULL)
    public List<Reservation> results;
}
