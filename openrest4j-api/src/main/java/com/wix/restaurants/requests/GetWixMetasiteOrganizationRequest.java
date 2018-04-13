package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Set;

/** Maps a Wix MetaSite to an organization. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWixMetasiteOrganizationRequest extends Request {
    public static final String TYPE = "get_wix_metasite_organization";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public GetWixMetasiteOrganizationRequest() {}

    public GetWixMetasiteOrganizationRequest(String metasiteId, Boolean full, Set<String> fields) {
        this.metasiteId = metasiteId;
        this.full = full;
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetWixMetasiteOrganizationRequest that = (GetWixMetasiteOrganizationRequest) o;

        if (metasiteId != null ? !metasiteId.equals(that.metasiteId) : that.metasiteId != null) return false;
        if (full != null ? !full.equals(that.full) : that.full != null) return false;
        return fields != null ? fields.equals(that.fields) : that.fields == null;
    }

    @Override
    public int hashCode() {
        int result = metasiteId != null ? metasiteId.hashCode() : 0;
        result = 31 * result + (full != null ? full.hashCode() : 0);
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        return result;
    }

    /** A Wix MetaSite ID. */
    @JsonInclude(Include.NON_NULL)
    public String metasiteId;

    /** Whether or not the "full" organization object is requested. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean full = Boolean.FALSE;

    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}