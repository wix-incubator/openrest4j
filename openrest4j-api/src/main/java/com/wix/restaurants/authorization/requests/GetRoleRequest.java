package com.wix.restaurants.authorization.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.ClientId;
import com.wix.restaurants.requests.Request;

/**
 * Returns a given user's role in an organization.
 * The returned role is normalized, e.g. a chain manager will also show as manager of each branch.
 *
 * Response value: {@link com.wix.restaurants.authorization.Role}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRoleRequest extends Request {
    public static final String TYPE = "get_role";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public GetRoleRequest() {}

    public GetRoleRequest(String accessToken, String organizationId, ClientId clientId) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.clientId = clientId;
    }

    /** An access token. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String accessToken;

    /** An organization identifier. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String organizationId;

    /** An optional client id. If null, the client id associated with the access token is used. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ClientId clientId;
}
