package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.Locale;

/**
 * Sends a download link to the dashboard's mobile app.
 * This should not be part of this API, and will be deprecated at some point.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendDashboardAppRequest extends Request {
    public static final String TYPE = "send_dashboard_app";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SendDashboardAppRequest() {}

    public SendDashboardAppRequest(String accessToken,
                                   String organizationId,
                                   String channelId,
                                   String channelParam,
                                   Locale locale) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.channelId = channelId;
        this.channelParam = channelParam;
        this.locale = locale;
    }

    /** Access token of the user that triggers the request. */
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** Identifies the organization relevant to the request. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    /** @see com.wix.restaurants.notifications.Channels */
    @JsonInclude(Include.NON_NULL)
    public String channelId;

    /** The channel-dependant parameter. */
    @JsonInclude(Include.NON_NULL)
    public String channelParam;

    /** The requested locale. */
    @JsonInclude(Include.NON_NULL)
    public Locale locale;
}
