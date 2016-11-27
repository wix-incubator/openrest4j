package com.wix.restaurants.reservations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Request;

import java.util.LinkedHashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryUnhandledReservationsRequest extends Request implements Cloneable {
    public static final String TYPE = "query_unhandled_reservations";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public QueryUnhandledReservationsRequest() {}

    public QueryUnhandledReservationsRequest(String accessToken, String organizationId, String viewMode, Set<String> fields) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.viewMode = viewMode;
        this.fields = fields;
    }

    @Override
    public Object clone() {
        return new QueryUnhandledReservationsRequest(accessToken, organizationId, viewMode,
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

    /** Optional response fields filter. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Set<String> fields;
}
