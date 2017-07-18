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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetRoleRequest that = (GetRoleRequest) o;

        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (organizationId != null ? !organizationId.equals(that.organizationId) : that.organizationId != null) return false;
        return clientId != null ? clientId.equals(that.clientId) : that.clientId == null;
    }

    @Override
    public int hashCode() {
        int result = accessToken != null ? accessToken.hashCode() : 0;
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
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
