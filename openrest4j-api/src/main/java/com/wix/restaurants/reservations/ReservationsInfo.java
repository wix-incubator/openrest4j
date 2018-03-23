package com.wix.restaurants.reservations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.IntegerInterval;
import com.wix.restaurants.availability.Availability;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Online reservations settings. */
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
    public ReservationsInfo clone() {
        return new ReservationsInfo(
                pendingApproval,
                (partySize != null) ? partySize.clone() : null,
                (availability != null) ? availability.clone() : null,
                (futureDelayMins != null) ? futureDelayMins.clone() : null,
                heldForMins,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationsInfo that = (ReservationsInfo) o;
        return Objects.equals(pendingApproval, that.pendingApproval) &&
                Objects.equals(partySize, that.partySize) &&
                Objects.equals(availability, that.availability) &&
                Objects.equals(futureDelayMins, that.futureDelayMins) &&
                Objects.equals(heldForMins, that.heldForMins) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pendingApproval, partySize, availability, futureDelayMins, heldForMins, properties);
    }

    @Override
    public String toString() {
        return "ReservationsInfo{" +
                "pendingApproval=" + pendingApproval +
                ", partySize=" + partySize +
                ", availability=" + availability +
                ", futureDelayMins=" + futureDelayMins +
                ", heldForMins=" + heldForMins +
                ", properties=" + properties +
                '}';
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
    public Map<String, String> properties = new LinkedHashMap<>();
}
