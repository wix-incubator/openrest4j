package com.wix.restaurants.reservations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wix.restaurants.requests.Request;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryModifiedReservationsRequest extends Request implements Cloneable {
    public static final String TYPE = "query_modified_reservations";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public QueryModifiedReservationsRequest() {}

    public QueryModifiedReservationsRequest(String accessToken, String organizationId, String viewMode,
                                            Date modifiedSince, Integer limit, Set<String> fields) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.viewMode = viewMode;
        this.modifiedSince = modifiedSince;
        this.limit = limit;
        this.fields = fields;
    }

    @Override
    public Object clone() {
        return new QueryModifiedReservationsRequest(accessToken, organizationId, viewMode,
                (modifiedSince != null) ? (Date) modifiedSince.clone() : null,
                limit,
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
     * Optional minimum value (including) of reservation last modification time.
     * @see com.wix.restaurants.reservations.Reservation#modified
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date modifiedSince;

    /** Optional maximum number of results to return. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer limit;

    /** Optional response fields filter. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Set<String> fields;
}
