package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Maps a Wix MetaSite to an organization. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapWixMetasiteRequest extends Request {
    public static final String TYPE = "map_wix_metasite";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public MapWixMetasiteRequest() {}

    public MapWixMetasiteRequest(String accessToken, String instance, String metasiteId, String organizationId) {
        this.accessToken = accessToken;
        this.instance = instance;
        this.metasiteId = metasiteId;
        this.organizationId = organizationId;
    }

    /** Access token (alternative: specify instance). */
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /**
     * App instance of a Wix site owner (alternative: specify accessToken).
     * @see <a href="http://dev.wix.com/docs/infrastructure/app-instance">App Instance</a>
     */
    @JsonInclude(Include.NON_NULL)
    public String instance;

    /** The Wix MetaSite ID to map. */
    @JsonInclude(Include.NON_NULL)
    public String metasiteId;

    /** The organization ID to map to, or null to clear existing mapping. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
