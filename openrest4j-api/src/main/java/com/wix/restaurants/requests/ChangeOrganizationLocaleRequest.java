package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeOrganizationLocaleRequest extends Request {
    public static final String TYPE = "change_organization_locale";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ChangeOrganizationLocaleRequest() {}

    public ChangeOrganizationLocaleRequest(String accessToken, String organizationId, Locale locale) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeOrganizationLocaleRequest that = (ChangeOrganizationLocaleRequest) o;

        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (organizationId != null ? !organizationId.equals(that.organizationId) : that.organizationId != null) return false;
        return locale != null ? locale.equals(that.locale) : that.locale == null;
    }

    @Override
    public int hashCode() {
        int result = accessToken != null ? accessToken.hashCode() : 0;
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    @JsonInclude(Include.NON_NULL)
    public Locale locale;
}
