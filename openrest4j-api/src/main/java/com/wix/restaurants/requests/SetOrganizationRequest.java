package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Organization;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetOrganizationRequest extends Request {
    public static final String TYPE = "set_organization";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetOrganizationRequest() {}
    
    public SetOrganizationRequest(String accessToken, Organization organization) {
    	this.accessToken = accessToken;
    	this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetOrganizationRequest that = (SetOrganizationRequest) o;

        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        return organization != null ? organization.equals(that.organization) : that.organization == null;
    }

    @Override
    public int hashCode() {
        int result = accessToken != null ? accessToken.hashCode() : 0;
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Organization organization;
}
