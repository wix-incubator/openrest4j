package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.ClientId;

import java.util.Objects;

/**
 * Removes all identifying information for a given customer from an organization.
 *
 * This is a destructive operation, provided to comply with "right to be forgotten" regulations.
 * @see <a href="https://en.wikipedia.org/wiki/General_Data_Protection_Regulation">General Data Protection Regulation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteCustomerRequest extends Request {
    public static final String TYPE = "delete_customer";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeleteCustomerRequest() {}

    public DeleteCustomerRequest(String accessToken, String organizationId, ClientId customerId) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteCustomerRequest that = (DeleteCustomerRequest) o;
        return Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(organizationId, that.organizationId) &&
                Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, organizationId, customerId);
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    @JsonInclude(Include.NON_NULL)
    public ClientId customerId;
}
