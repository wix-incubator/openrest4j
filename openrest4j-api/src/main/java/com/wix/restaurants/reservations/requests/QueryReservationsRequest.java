package com.wix.restaurants.reservations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Request;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryReservationsRequest extends Request implements Cloneable {
    public static final String TYPE = "query_reservations";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public QueryReservationsRequest() {}

    public QueryReservationsRequest(String accessToken, String organizationId, String viewMode,
                                    Date dueSince, Date dueUntil, String ordering, Integer limit, Set<String> fields) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.viewMode = viewMode;
        this.dueSince = dueSince;
        this.dueUntil = dueUntil;
        this.ordering = ordering;
        this.limit = limit;
        this.fields = fields;
    }

    @Override
    public Object clone() {
        return new QueryReservationsRequest(accessToken, organizationId, viewMode,
                (dueSince != null) ? (Date) dueSince.clone() : null,
                (dueUntil != null) ? (Date) dueUntil.clone() : null,
                ordering, limit,
                (fields != null) ? new LinkedHashSet<>(fields) : null);
    }

    /** User access token. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String accessToken;

    /** Retrieve unhandled reservations for this organization. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String organizationId;

    /** @see com.wix.restaurants.Actors */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String viewMode;

    /**
     * Optional minimum value (including) of reservation due date.
     * @see com.wix.restaurants.reservations.Reservation#time
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date dueSince;

    /**
     * Optional maximum value (excluding) of reservation due date.
     * @see com.wix.restaurants.reservations.Reservation#time
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date dueUntil;

    /**
     * Optional result ordering.
     * @see com.wix.restaurants.Orderings
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String ordering;

    /** Optional maximum number of results to return. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer limit;

    /** Optional response fields filter. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Set<String> fields;
}
