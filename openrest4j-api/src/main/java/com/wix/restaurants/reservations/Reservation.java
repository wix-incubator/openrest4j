package com.wix.restaurants.reservations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Contact;
import com.openrest.v1_1.User;
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
                       List<LogEntry> log, Map<String, String> properties) {
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
    }

    /** Default constructor for JSON deserialization. */
    public Reservation() {}

    @Override
    public Object clone() {
        return new Reservation(id,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                (created != null) ? (Date) created.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
                restaurantId, chainId, distributorId,
                timeGuarantee,
                (time != null) ? (Date) time.clone() : null,
                (heldUntil != null) ? (Date) heldUntil.clone() : null,
                (contact != null) ? (Contact) contact.clone() : null,
                partySize, comment, locale,
                ownerToken, shareToken,
                status, restaurantStatus, customerStatus,
                (user != null) ? (User) user.clone() : null,
                developer, source, platform,
                LogEntry.clone(log),
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (externalIds != null ? !externalIds.equals(that.externalIds) : that.externalIds != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (modified != null ? !modified.equals(that.modified) : that.modified != null) return false;
        if (restaurantId != null ? !restaurantId.equals(that.restaurantId) : that.restaurantId != null) return false;
        if (chainId != null ? !chainId.equals(that.chainId) : that.chainId != null) return false;
        if (distributorId != null ? !distributorId.equals(that.distributorId) : that.distributorId != null) return false;
        if (timeGuarantee != null ? !timeGuarantee.equals(that.timeGuarantee) : that.timeGuarantee != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (heldUntil != null ? !heldUntil.equals(that.heldUntil) : that.heldUntil != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (partySize != null ? !partySize.equals(that.partySize) : that.partySize != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (locale != null ? !locale.equals(that.locale) : that.locale != null) return false;
        if (ownerToken != null ? !ownerToken.equals(that.ownerToken) : that.ownerToken != null) return false;
        if (shareToken != null ? !shareToken.equals(that.shareToken) : that.shareToken != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (restaurantStatus != null ? !restaurantStatus.equals(that.restaurantStatus) : that.restaurantStatus != null) return false;
        if (customerStatus != null ? !customerStatus.equals(that.customerStatus) : that.customerStatus != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (developer != null ? !developer.equals(that.developer) : that.developer != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
        if (log != null ? !log.equals(that.log) : that.log != null) return false;
        return properties != null ? properties.equals(that.properties) : that.properties == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (chainId != null ? chainId.hashCode() : 0);
        result = 31 * result + (distributorId != null ? distributorId.hashCode() : 0);
        result = 31 * result + (timeGuarantee != null ? timeGuarantee.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (heldUntil != null ? heldUntil.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (partySize != null ? partySize.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + (ownerToken != null ? ownerToken.hashCode() : 0);
        result = 31 * result + (shareToken != null ? shareToken.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (restaurantStatus != null ? restaurantStatus.hashCode() : 0);
        result = 31 * result + (customerStatus != null ? customerStatus.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (developer != null ? developer.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (log != null ? log.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
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
    public Map<String, String> externalIds;

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
     * An empty String means the restaurant's (or chain's) white-label system.
     */
    @JsonInclude(Include.NON_NULL)
    public String source;

    /**
     * The platform through which the customer reserved.
     * @see com.openrest.v1_1.AppId#ALL_PLATFORMS
     */
    @JsonInclude(Include.NON_NULL)
    public String platform;

    /** Change log for this reservation. */
    @JsonInclude(Include.NON_NULL)
    public List<LogEntry> log;

    /**
     * Map of user-defined extended properties.
     * Developers should use unique keys, e.g. "com.example.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> properties;
}
