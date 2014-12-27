package com.openrest.olo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.openrest.v1_1.Request;
import com.openrest.v1_1.Stats;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetPotentialWeeklyStatsRequest extends Request {
    public static final String TYPE = "set_potential_weekly_stats";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SetPotentialWeeklyStatsRequest() {}

    public SetPotentialWeeklyStatsRequest(String accessToken, String organizationId, Stats stats) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.stats = stats;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    @JsonInclude(Include.NON_NULL)
    public Stats stats;
}
