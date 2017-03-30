package com.wix.restaurants.orders.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.wix.restaurants.requests.Request;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPotentialWeeklyStatsRequest extends Request {
    public static final String TYPE = "get_potential_weekly_stats";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public GetPotentialWeeklyStatsRequest() {}

    public GetPotentialWeeklyStatsRequest(String accessToken, String organizationId) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
