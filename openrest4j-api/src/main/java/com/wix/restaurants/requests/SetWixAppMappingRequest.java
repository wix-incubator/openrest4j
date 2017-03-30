package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetWixAppMappingRequest extends Request {
    public static final String TYPE = "set_wix_app_mapping";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SetWixAppMappingRequest() {}

    public SetWixAppMappingRequest(String accessToken, String appKey, String instance, String instanceId, String organizationId) {
        this.accessToken = accessToken;
        this.appKey = appKey;
        this.instance = instance;
        this.instanceId = instanceId;
        this.organizationId = organizationId;
    }

    /** Access token (alternative: specify appKey and instance). */
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** Key of the Wix app for which the instance belongs to (alternative: specify accessToken). */
    @JsonInclude(Include.NON_NULL)
    public String appKey;

    /**
     * App instance of a Wix site owner (alternative: specify accessToken).
     * @see <a href="http://dev.wix.com/docs/infrastructure/app-instance">App Instance</a>
     */
    @JsonInclude(Include.NON_NULL)
    public String instance;

    /**
     * The Wix App Instance ID to map.
     * @see <a href="http://dev.wix.com/docs/infrastructure/app-instance-id#overview">App Instance ID</a>
     */
    @JsonInclude(Include.NON_NULL)
    public String instanceId;

    /** The organization ID to map to, or null to clear existing mapping. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
