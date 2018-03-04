package com.wix.restaurants.orders.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.ClientId;
import com.wix.restaurants.requests.Request;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryCustomerOrdersRequest extends Request implements Cloneable {
    public static final String TYPE = "query_customer_orders";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public QueryCustomerOrdersRequest() {}

    public QueryCustomerOrdersRequest(String accessToken, String organizationId, ClientId customerId,
                                      Date modifiedSince, Integer limit, Set<String> fields) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.customerId = customerId;
        this.modifiedSince = modifiedSince;
        this.limit = limit;
        this.fields = fields;
    }

    @Override
    public QueryCustomerOrdersRequest clone() throws CloneNotSupportedException {
        return new QueryCustomerOrdersRequest(accessToken, organizationId,
                (customerId != null) ? customerId.clone() : null,
                (modifiedSince != null) ? (Date) modifiedSince.clone() : null,
                limit,
                (fields != null) ? new LinkedHashSet<>(fields) : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryCustomerOrdersRequest that = (QueryCustomerOrdersRequest) o;
        return Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(organizationId, that.organizationId) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(modifiedSince, that.modifiedSince) &&
                Objects.equals(limit, that.limit) &&
                Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, organizationId, customerId, modifiedSince, limit, fields);
    }

    @Override
    public String toString() {
        return "QueryCustomerOrdersRequest{" +
                "accessToken='" + accessToken + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", customerId=" + customerId +
                ", modifiedSince=" + modifiedSince +
                ", limit=" + limit +
                ", fields=" + fields +
                '}';
    }

    /** User access token. */
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** Retrieve orders for this organization. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    /** Retrieve orders for this customer. */
    @JsonInclude(Include.NON_NULL)
    public ClientId customerId;

    /**
     * Optional minimum value (including) of order last modification time.
     * @see com.openrest.v1_1.Order#modified
     */
    @JsonInclude(Include.NON_NULL)
    public Date modifiedSince;

    /** Optional maximum number of results to return. */
    @JsonInclude(Include.NON_NULL)
    public Integer limit;

    /** Optional response fields filter. */
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
