package com.wix.restaurants.reservations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Request;
import com.wix.restaurants.reservations.Reservation;

import java.util.LinkedHashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetReservationRequest extends Request implements Cloneable {
    public static final String TYPE = "get_reservation";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public GetReservationRequest() {}

    public GetReservationRequest(String accessToken, String ownerToken, String shareToken,
                                 String reservationId, String viewMode,
                                 Set<String> fields) {
        this.accessToken = accessToken;
        this.ownerToken = ownerToken;
        this.shareToken = shareToken;
        this.reservationId = reservationId;
        this.viewMode = viewMode;
        this.fields = fields;
    }

    @Override
    public Object clone() {
        return new GetReservationRequest(accessToken, ownerToken, shareToken, reservationId, viewMode,
                (fields != null) ? new LinkedHashSet<>(fields) : null);
    }

    /** User access token (null if using ownerToken or shareToken). */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String accessToken;

    /**
     * Owner token for viewing the reservation as owner (null if using accessToken or shareToken).
     * @see Reservation#ownerToken
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String ownerToken;

    /**
     * Share token for viewing a shared reservation (null if using accessToken or ownerToken).
     * @see Reservation#shareToken
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String shareToken;

    /** The reservation's unique identifier. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String reservationId;

    /** @see com.wix.restaurants.Actors */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String viewMode;

    /** Optional response fields filter. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Set<String> fields;
}
