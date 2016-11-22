package com.wix.restaurants.reservations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.IntegerInterval;
import com.wix.restaurants.availability.Availability;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationsInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ReservationsInfo() {}

    public ReservationsInfo(Boolean pendingApproval,
                            IntegerInterval partySize,
                            Availability availability,
                            IntegerInterval futureDelayMins,
                            Integer heldForMins,
                            Map<String, String> properties) {
        this.pendingApproval = pendingApproval;
        this.partySize = partySize;
        this.availability = availability;
        this.futureDelayMins = futureDelayMins;
        this.heldForMins = heldForMins;
        this.properties = properties;
    }

    @Override
    public Object clone() {
        return new ReservationsInfo(
                pendingApproval,
                (partySize != null) ? (IntegerInterval) partySize.clone() : null,
                (availability != null) ? (Availability) availability.clone() : null,
                (futureDelayMins != null) ? (IntegerInterval) futureDelayMins.clone() : null,
                heldForMins,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationsInfo that = (ReservationsInfo) o;

        if (pendingApproval != null ? !pendingApproval.equals(that.pendingApproval) : that.pendingApproval != null) return false;
        if (partySize != null ? !partySize.equals(that.partySize) : that.partySize != null) return false;
        if (availability != null ? !availability.equals(that.availability) : that.availability != null) return false;
        if (futureDelayMins != null ? !futureDelayMins.equals(that.futureDelayMins) : that.futureDelayMins != null) return false;
        if (heldForMins != null ? !heldForMins.equals(that.heldForMins) : that.heldForMins != null) return false;
        return properties != null ? properties.equals(that.properties) : that.properties == null;

    }

    @Override
    public int hashCode() {
        int result = pendingApproval != null ? pendingApproval.hashCode() : 0;
        result = 31 * result + (partySize != null ? partySize.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        result = 31 * result + (futureDelayMins != null ? futureDelayMins.hashCode() : 0);
        result = 31 * result + (heldForMins != null ? heldForMins.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    /** If true, submitted reservations are not final until manually approved by the restaurant. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean pendingApproval = Boolean.FALSE;

    /** Allowed party sizes (minimum is mandatory, and strictly positive). */
    @JsonInclude(Include.NON_NULL)
    public IntegerInterval partySize;

    /**
     * The restaurant accepts reservations to these times.
     * @see #futureDelayMins for limitations.
     */
    @JsonInclude(Include.NON_NULL)
    public Availability availability;

    /**
     * Time interval in which future reservations are allowed (minimum is mandatory, and non-negative),
     * or null if future reservations are not allowed.
     *
     * For example, min=1440 max=10080 means that future reservations must be placed at least 1 day in advance,
     * and at most 7 days in advance.
     */
    @JsonInclude(Include.NON_NULL)
    public IntegerInterval futureDelayMins;

    /** How long (in minutes) are tables held for late customers, or null if unlimited. */
    @JsonInclude(Include.NON_NULL)
    public Integer heldForMins;

    /**
     * Map of user-defined extended properties.
     * Developers should use unique keys, e.g. "com.example.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> properties;
}
