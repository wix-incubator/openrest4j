package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ToggleInactiveRequest extends Request {
    public static final String TYPE = "toggle_inactive";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ToggleInactiveRequest() {}

    public ToggleInactiveRequest(String accessToken, String organizationId, Boolean activate) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.activate = activate;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    @JsonInclude(Include.NON_NULL)
    public Boolean activate;
}
