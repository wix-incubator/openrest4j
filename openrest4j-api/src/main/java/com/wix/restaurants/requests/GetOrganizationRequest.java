package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrganizationRequest extends Request {
    public static final String TYPE = "get_organization";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrganizationRequest() {}
    
    public GetOrganizationRequest(String organizationId, Set<String> fields) {
    	this.organizationId = organizationId;
    	this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetOrganizationRequest that = (GetOrganizationRequest) o;
        return Objects.equals(organizationId, that.organizationId) &&
                Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, fields);
    }

    @Override
    public String toString() {
        return "GetOrganizationRequest{" +
                "organizationId='" + organizationId + '\'' +
                ", fields=" + fields +
                '}';
    }

    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
