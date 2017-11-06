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

    /** A Wix MetaSite ID. */
    @JsonInclude(Include.NON_NULL)
    public String metasiteId;

    /** Whether or not the "full" organization object is requested. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean full = Boolean.FALSE;

    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
