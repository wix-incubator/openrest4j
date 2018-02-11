package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Objects;

/**
 * Removes all identifying information from an organization.
 *
 * This is a destructive operation, provided to comply with "right to be forgotten" regulations.
 * @see <a href="https://en.wikipedia.org/wiki/General_Data_Protection_Regulation">General Data Protection Regulation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteOrganizationRequest extends Request {
    public static final String TYPE = "delete_organization";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeleteOrganizationRequest() {}

    public DeleteOrganizationRequest(String accessToken, String organizationId) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteOrganizationRequest that = (DeleteOrganizationRequest) o;
        return Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, organizationId);
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
