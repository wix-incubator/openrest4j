package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetFacebookAppMappingRequest extends Request {
    public static final String TYPE = "set_facebook_app_mapping";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SetFacebookAppMappingRequest() {}

    public SetFacebookAppMappingRequest(String accessToken, String fbAccessToken, String fbPageId, String organizationId) {
        this.accessToken = accessToken;
        this.fbAccessToken = fbAccessToken;
        this.fbPageId = fbPageId;
        this.organizationId = organizationId;
    }

    /** Access token (alternative: specify fbAccessToken). */
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** Facebook access token of a page owner (alternative: specify accessToken). */
    @JsonInclude(Include.NON_NULL)
    public String fbAccessToken;

    /** The Facebook page ID to map. */
    @JsonInclude(Include.NON_NULL)
    public String fbPageId;

    /** The organization ID to map to, or null to clear existing mapping. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
