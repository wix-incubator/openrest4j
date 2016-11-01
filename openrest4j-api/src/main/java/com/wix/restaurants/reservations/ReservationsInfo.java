package com.wix.restaurants.reservations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationsInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ReservationsInfo() {}

    public ReservationsInfo(Boolean pendingApproval,
                            Integer minPartySize,
                            Integer maxPartySize,
                            Integer minFutureDelayMins,
                            Integer maxFutureDelayMins,
                            Map<String, String> properties) {
        this.pendingApproval = pendingApproval;
        this.minPartySize = minPartySize;
        this.maxPartySize = maxPartySize;
        this.minFutureDelayMins = minFutureDelayMins;
        this.maxFutureDelayMins = maxFutureDelayMins;
        this.properties = properties;
    }

    @Override
    public Object clone() {
        return new ReservationsInfo(
                pendingApproval,
                minPartySize,
                maxPartySize,
                minFutureDelayMins,
                maxFutureDelayMins,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationsInfo that = (ReservationsInfo) o;

        if (pendingApproval != null ? !pendingApproval.equals(that.pendingApproval) : that.pendingApproval != null) return false;
        if (minPartySize != null ? !minPartySize.equals(that.minPartySize) : that.minPartySize != null) return false;
        if (maxPartySize != null ? !maxPartySize.equals(that.maxPartySize) : that.maxPartySize != null) return false;
        if (minFutureDelayMins != null ? !minFutureDelayMins.equals(that.minFutureDelayMins) : that.minFutureDelayMins != null) return false;
        if (maxFutureDelayMins != null ? !maxFutureDelayMins.equals(that.maxFutureDelayMins) : that.maxFutureDelayMins != null) return false;
        return properties != null ? properties.equals(that.properties) : that.properties == null;

    }

    @Override
    public int hashCode() {
        int result = pendingApproval != null ? pendingApproval.hashCode() : 0;
        result = 31 * result + (minPartySize != null ? minPartySize.hashCode() : 0);
        result = 31 * result + (maxPartySize != null ? maxPartySize.hashCode() : 0);
        result = 31 * result + (minFutureDelayMins != null ? minFutureDelayMins.hashCode() : 0);
        result = 31 * result + (maxFutureDelayMins != null ? maxFutureDelayMins.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    /** If true, submitted reservations are not final until manually approved by the restaurant. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean pendingApproval = Boolean.FALSE;

    /** Minimum party size allowed. */
    @JsonInclude(Include.NON_NULL)
    public Integer minPartySize;

    /** Maximum party size allowed, or null for no maximum. */
    @JsonInclude(Include.NON_NULL)
    public Integer maxPartySize;

    /**
     * Earliest time from which future reservations are allowed, or null for no limit.
     * For example, a value of 1440 means future reservations must be placed at least 1 day in advance.
     */
    @JsonInclude(Include.NON_NULL)
    public Integer minFutureDelayMins;

    /**
     * Latest time up to which future reservations are allowed, or null for no limit.
     * For example, a value of 10080 means future reservations are accepted up to 7 days in advance.
     */
    @JsonInclude(Include.NON_NULL)
    public Integer maxFutureDelayMins;

    /**
     * Map of user-defined extended properties.
     * Developers should use unique keys, e.g. "com.example.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> properties;
}
