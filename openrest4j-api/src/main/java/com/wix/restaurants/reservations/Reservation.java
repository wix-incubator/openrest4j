package com.wix.restaurants.reservations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Contact;
import com.openrest.v1_1.User;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.reservations.log.LogEntry;

import java.io.Serializable;
import java.util.*;

/**
 * A table reservation.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Table_reservation">Table reservation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public Reservation(String id, Map<String, String> externalIds, Date created, Date modified,
                       String restaurantId, String chainId, String distributorId,
                       String timeGuarantee, Date time, Date heldUntil,
                       Contact contact, Integer partySize, String comment, Locale locale,
                       String ownerToken, String shareToken,
                       String status, String restaurantStatus, String customerStatus,
                       User user,
                       String developer, String source, String platform,
                       List<LogEntry> log, Map<String, String> properties,
                       String locationId) {
        this.id = id;
        this.externalIds = externalIds;
        this.created = created;
        this.modified = modified;
        this.restaurantId = restaurantId;
        this.chainId = chainId;
        this.distributorId = distributorId;
        this.timeGuarantee = timeGuarantee;
        this.time = time;
        this.heldUntil = heldUntil;
        this.contact = contact;
        this.partySize = partySize;
        this.comment = comment;
        this.locale = locale;
        this.ownerToken = ownerToken;
        this.shareToken = shareToken;
        this.status = status;
        this.restaurantStatus = restaurantStatus;
        this.customerStatus = customerStatus;
        this.user = user;
        this.developer = developer;
        this.source = source;
        this.platform = platform;
        this.log = log;
        this.properties = properties;
        this.locationId = locationId;
    }

    /** Default constructor for JSON deserialization. */
    public Reservation() {}

    @Override
    public Reservation clone() {
        return new Reservation(id,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                (created != null) ? (Date) created.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
                restaurantId, chainId, distributorId,
                timeGuarantee,
                (time != null) ? (Date) time.clone() : null,
                (heldUntil != null) ? (Date) heldUntil.clone() : null,
                (contact != null) ? contact.clone() : null,
                partySize, comment, locale,
                ownerToken, shareToken,
                status, restaurantStatus, customerStatus,
                (user != null) ? user.clone() : null,
                developer, source, platform,
                LogEntry.clone(log),
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                locationId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(externalIds, that.externalIds) &&
                Objects.equals(created, that.created) &&
                Objects.equals(modified, that.modified) &&
                Objects.equals(restaurantId, that.restaurantId) &&
                Objects.equals(chainId, that.chainId) &&
                Objects.equals(distributorId, that.distributorId) &&
                Objects.equals(timeGuarantee, that.timeGuarantee) &&
                Objects.equals(time, that.time) &&
                Objects.equals(heldUntil, that.heldUntil) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(partySize, that.partySize) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(locale, that.locale) &&
                Objects.equals(ownerToken, that.ownerToken) &&
                Objects.equals(shareToken, that.shareToken) &&
                Objects.equals(status, that.status) &&
                Objects.equals(restaurantStatus, that.restaurantStatus) &&
                Objects.equals(customerStatus, that.customerStatus) &&
                Objects.equals(user, that.user) &&
                Objects.equals(developer, that.developer) &&
                Objects.equals(source, that.source) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(log, that.log) &&
                Objects.equals(properties, that.properties) &&
                Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalIds, created, modified, restaurantId, chainId, distributorId, timeGuarantee, time, heldUntil, contact, partySize, comment, locale, ownerToken, shareToken, status, restaurantStatus, customerStatus, user, developer, source, platform, log, properties, locationId);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", externalIds=" + externalIds +
                ", created=" + created +
                ", modified=" + modified +
                ", restaurantId='" + restaurantId + '\'' +
                ", chainId='" + chainId + '\'' +
                ", distributorId='" + distributorId + '\'' +
                ", timeGuarantee='" + timeGuarantee + '\'' +
                ", time=" + time +
                ", heldUntil=" + heldUntil +
                ", contact=" + contact +
                ", partySize=" + partySize +
                ", comment='" + comment + '\'' +
                ", locale=" + locale +
                ", ownerToken='" + ownerToken + '\'' +
                ", shareToken='" + shareToken + '\'' +
                ", status='" + status + '\'' +
                ", restaurantStatus='" + restaurantStatus + '\'' +
                ", customerStatus='" + customerStatus + '\'' +
                ", user=" + user +
                ", developer='" + developer + '\'' +
                ", source='" + source + '\'' +
                ", platform='" + platform + '\'' +
                ", log=" + log +
                ", properties=" + properties +
                ", locationId=" + locationId +
                '}';
    }

    /** The reservation's unique identifier. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /**
     * Map of externally-defined identifiers referring to this reservation, e.g. the reservation's identifier in an
     * external ERB.
     *
     * Developers should use unique keys, e.g. "com.example.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> externalIds = new LinkedHashMap<>();

    /** The reservation's creation timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date created;

    /** The reservation's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date modified;

    /** The restaurant's unique identifier. */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;

    /** The chain's unique identifier, if restaurant is a branch. */
    @JsonInclude(Include.NON_NULL)
    public String chainId;

    /** The distributor's unique identifier. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;

    /**
     * The type of time guarantee given.
     * @see com.wix.restaurants.TimeGuarantees
     * @see Reservation#time
     */
    @JsonInclude(Include.NON_NULL)
    public String timeGuarantee;

    /**
     * The reservation's guaranteed time.
     * @see Reservation#timeGuarantee
     */
    @JsonInclude(Include.NON_NULL)
    public Date time;

    /** The latest arrival time after which the table will no longer be reserved, or null if unlimited. */
    @JsonInclude(Include.NON_NULL)
    public Date heldUntil;

    /** The customer's contact information. */
    @JsonInclude(Include.NON_NULL)
    public Contact contact;

    /** The party size. */
    @JsonInclude(Include.NON_NULL)
    public Integer partySize;

    /** Optional customer comment. */
    @JsonInclude(Include.NON_NULL)
    public String comment;

    /** The reservation's locale. */
    @JsonInclude(Include.NON_NULL)
    public Locale locale;

    /** Grants owner-access to the reservation. */
    @JsonInclude(Include.NON_NULL)
    public String ownerToken;

    /** Grants share-access to the reservation. */
    @JsonInclude(Include.NON_NULL)
    public String shareToken;

    /**
     * The reservation's status.
     * @see Statuses
     */
    @JsonInclude(Include.NON_NULL)
    public String status;

    /**
     * The reservation's status from the restaurant's perspective.
     * @see Statuses
     */
    @JsonInclude(Include.NON_NULL)
    public String restaurantStatus;

    /**
     * The reservation's status from the customer's perspective.
     * @see Statuses
     */
    @JsonInclude(Include.NON_NULL)
    public String customerStatus;

    /** The user who created the reservation. */
    @JsonInclude(Include.NON_NULL)
    public User user;

    /** Identifies the technical client's developer. */
    @JsonInclude(Include.NON_NULL)
    public String developer;

    /**
     * Identifies the organization from which the customer reserved.
     * @see com.wix.restaurants.Sources
     */
    @JsonInclude(Include.NON_NULL)
    public String source;

    /**
     * The platform through which the customer reserved.
     * @see com.wix.restaurants.Platforms
     */
    @JsonInclude(Include.NON_NULL)
    public String platform;

    /** Change log for this reservation. */
    @JsonInclude(Include.NON_NULL)
    public List<LogEntry> log = new LinkedList<>();

    /**
     * Map of user-defined extended properties.
     * Developers should use unique keys, e.g. "com.example.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> properties = new LinkedHashMap<>();

    /** The location id which the customer used when made the reservation **/
    @JsonInclude(Include.NON_NULL)
    public String locationId;
}
