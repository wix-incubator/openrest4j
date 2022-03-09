package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.OrderCharge;
import com.openrest.olo.dispatches.Dispatch;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.payments.Payment;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Constructs a previously submitted order from persisted data. */
    public Order(String id, Map<String, String> externalIds, String distributorId, String chainId, String restaurantId,
    		Locale locale, List<OrderItem> orderItems,
    		String comment, Integer price, String currency, Dispatch delivery, Contact contact, List<Payment> payments,
            Integer takeoutPacks, List<OrderCharge> orderCharges,
            Date created, Date received, Date modified, Date submitAt,
            User user, ClubMember clubMember, String status, String shareToken, String ownerToken,
            String affiliate, String developer, String source, String platform, Coupon coupon,
            Boolean legacyHierarchy, Map<String, String> properties, List<LogEntry> log, String gatewayReturnUrl, String locationId) {
        this(id, externalIds, distributorId, chainId, restaurantId, locale, orderItems, comment, price, currency, delivery, contact, payments,
                takeoutPacks,  orderCharges, created, received, modified, submitAt,
                user, clubMember, status, shareToken, ownerToken, affiliate, developer, source, platform, coupon,
                legacyHierarchy, properties, log, gatewayReturnUrl, locationId, null);
    }

    /** Constructs a previously submitted order from persisted data. */
    public Order(String id, Map<String, String> externalIds, String distributorId, String chainId, String restaurantId,
                 Locale locale, List<OrderItem> orderItems,
                 String comment, Integer price, String currency, Dispatch delivery, Contact contact, List<Payment> payments,
                 Integer takeoutPacks, List<OrderCharge> orderCharges,
                 Date created, Date received, Date modified, Date submitAt,
                 User user, ClubMember clubMember, String status, String shareToken, String ownerToken,
                 String affiliate, String developer, String source, String platform, Coupon coupon,
                 Boolean legacyHierarchy, Map<String, String> properties, List<LogEntry> log, String gatewayReturnUrl, String locationId,
                 Loyalty loyalty) {

        this.id = id;
        this.externalIds = externalIds;
        this.distributorId = distributorId;
        this.chainId = chainId;
        this.restaurantId = restaurantId;
        this.locale = locale;
        this.orderItems = orderItems;
        this.comment = comment;
        this.price = price;
        this.currency = currency;
        this.delivery = delivery;
        this.contact = contact;
        this.payments = payments;
        this.takeoutPacks = takeoutPacks;
        this.orderCharges = orderCharges;
        this.created = created;
        this.received = received;
        this.modified = modified;
        this.submitAt = submitAt;
        this.user = user;
        this.clubMember = clubMember;
        this.status = status;
        this.shareToken = shareToken;
        this.ownerToken = ownerToken;
        this.affiliate = affiliate;
        this.developer = developer;
        this.source = source;
        this.platform = platform;
        this.coupon = coupon;
        this.legacyHierarchy = legacyHierarchy;
        this.properties = properties;
        this.log = log;
        this.gatewayReturnUrl = gatewayReturnUrl;
        this.locationId = locationId;
        this.loyalty = loyalty;
    }

    /** Constructs a previously submitted order from persisted data. */
    public Order(String id, Map<String, String> externalIds, String distributorId, String chainId, String restaurantId,
                 Locale locale, List<OrderItem> orderItems,
                 String comment, Integer price, String currency, Dispatch delivery, Contact contact, List<Payment> payments,
                 Integer takeoutPacks, List<OrderCharge> orderCharges,
                 Date created, Date received, Date modified, Date submitAt,
                 User user, ClubMember clubMember, String status, String shareToken, String ownerToken,
                 String affiliate, String developer, String source, String platform, Coupon coupon,
                 Boolean legacyHierarchy, Map<String, String> properties, List<LogEntry> log, String gatewayReturnUrl, String locationId,
                 Loyalty loyalty, PosInfo posInfo) {

        this.id = id;
        this.externalIds = externalIds;
        this.distributorId = distributorId;
        this.chainId = chainId;
        this.restaurantId = restaurantId;
        this.locale = locale;
        this.orderItems = orderItems;
        this.comment = comment;
        this.price = price;
        this.currency = currency;
        this.delivery = delivery;
        this.contact = contact;
        this.payments = payments;
        this.takeoutPacks = takeoutPacks;
        this.orderCharges = orderCharges;
        this.created = created;
        this.received = received;
        this.modified = modified;
        this.submitAt = submitAt;
        this.user = user;
        this.clubMember = clubMember;
        this.status = status;
        this.shareToken = shareToken;
        this.ownerToken = ownerToken;
        this.affiliate = affiliate;
        this.developer = developer;
        this.source = source;
        this.platform = platform;
        this.coupon = coupon;
        this.legacyHierarchy = legacyHierarchy;
        this.properties = properties;
        this.log = log;
        this.gatewayReturnUrl = gatewayReturnUrl;
        this.locationId = locationId;
        this.loyalty = loyalty;
        this.posInfo = posInfo;
    }

    /** Default constructor for JSON deserialization. */
    public Order() {}

    @Override
	public Order clone() {
    	return new Order(id,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
    			distributorId, chainId, restaurantId, locale, OrderItem.clone(orderItems), comment, price, currency,
    			((delivery != null) ? delivery.clone() : null),
    			((contact != null) ? contact.clone() : null),
    			Payment.clone(payments), takeoutPacks, OrderCharge.clone(orderCharges),
                (created != null) ? (Date) created.clone() : null,
                (received != null) ? (Date) received.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
                (submitAt != null) ? (Date) submitAt.clone() : null,
    			((user != null) ? user.clone() : null),
    			((clubMember != null) ? clubMember.clone() : null),
    			status, shareToken, ownerToken, affiliate, developer, source, platform,
                ((coupon != null ? coupon.clone() : null)),
                legacyHierarchy,
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			LogEntry.clone(log),
                gatewayReturnUrl,
                locationId,
                (loyalty != null) ? loyalty.clone() : null,
                (posInfo != null) ? posInfo.close() : null);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(externalIds, order.externalIds) &&
                Objects.equals(distributorId, order.distributorId) &&
                Objects.equals(chainId, order.chainId) &&
                Objects.equals(restaurantId, order.restaurantId) &&
                Objects.equals(locale, order.locale) &&
                Objects.equals(orderItems, order.orderItems) &&
                Objects.equals(comment, order.comment) &&
                Objects.equals(price, order.price) &&
                Objects.equals(currency, order.currency) &&
                Objects.equals(delivery, order.delivery) &&
                Objects.equals(contact, order.contact) &&
                Objects.equals(payments, order.payments) &&
                Objects.equals(takeoutPacks, order.takeoutPacks) &&
                Objects.equals(orderCharges, order.orderCharges) &&
                Objects.equals(created, order.created) &&
                Objects.equals(submitAt, order.submitAt) &&
                Objects.equals(received, order.received) &&
                Objects.equals(modified, order.modified) &&
                Objects.equals(user, order.user) &&
                Objects.equals(clubMember, order.clubMember) &&
                Objects.equals(status, order.status) &&
                Objects.equals(shareToken, order.shareToken) &&
                Objects.equals(ownerToken, order.ownerToken) &&
                Objects.equals(affiliate, order.affiliate) &&
                Objects.equals(developer, order.developer) &&
                Objects.equals(source, order.source) &&
                Objects.equals(platform, order.platform) &&
                Objects.equals(coupon, order.coupon) &&
                Objects.equals(legacyHierarchy, order.legacyHierarchy) &&
                Objects.equals(properties, order.properties) &&
                Objects.equals(log, order.log) &&
                Objects.equals(gatewayReturnUrl, order.gatewayReturnUrl) &&
                Objects.equals(locationId, order.locationId) &&
                Objects.equals(loyalty, order.loyalty) &&
                Objects.equals(posInfo, order.posInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalIds, distributorId, chainId, restaurantId, locale, orderItems, comment, price, currency, delivery, contact, payments, takeoutPacks, orderCharges, created, submitAt, received, modified, user, clubMember, status, shareToken, ownerToken, affiliate, developer, source, platform, coupon, legacyHierarchy, properties, log, gatewayReturnUrl, locationId, loyalty, posInfo);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", externalIds=" + externalIds +
                ", distributorId='" + distributorId + '\'' +
                ", chainId='" + chainId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", locale=" + locale +
                ", orderItems=" + orderItems +
                ", comment='" + comment + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", delivery=" + delivery +
                ", contact=" + contact +
                ", payments=" + payments +
                ", takeoutPacks=" + takeoutPacks +
                ", orderCharges=" + orderCharges +
                ", created=" + created +
                ", submitAt=" + submitAt +
                ", received=" + received +
                ", modified=" + modified +
                ", user=" + user +
                ", clubMember=" + clubMember +
                ", status='" + status + '\'' +
                ", shareToken='" + shareToken + '\'' +
                ", ownerToken='" + ownerToken + '\'' +
                ", affiliate='" + affiliate + '\'' +
                ", developer='" + developer + '\'' +
                ", source='" + source + '\'' +
                ", platform='" + platform + '\'' +
                ", coupon='" + coupon + '\'' +
                ", legacyHierarchy=" + legacyHierarchy +
                ", properties=" + properties +
                ", log=" + log +
                ", gatewayReturnUrl=" + gatewayReturnUrl +
                ", locationId=" + locationId +
                ", loyalty=" + loyalty +
                ", posInfo=" + posInfo +
                '}';
    }

    /** The order's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<>();

    /** The distributor's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;

    /** The chain's unique id (can be null). */
    @JsonInclude(Include.NON_NULL)
    public String chainId;

    /** The restaurant's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;

    /** The order's locale. */
    @JsonInclude(Include.NON_NULL)
    public Locale locale;

    /** The ordered items. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<OrderItem> orderItems = new LinkedList<>();

    /** Comment to the restaurant (as opposed to the delivery person!). */
    @JsonInclude(Include.NON_NULL)
    public String comment;

    /** Total price of the order. */
    @JsonInclude(Include.NON_NULL)
    public Integer price;

    /** The order's currency (ISO 4217). */
    @JsonInclude(Include.NON_NULL)
    public String currency;

    /* Delivery method. */
    @JsonInclude(Include.NON_NULL)
    public Dispatch delivery;

    /* Contact details. */
    @JsonInclude(Include.NON_NULL)
    public Contact contact;

    /* Payments. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Payment> payments = new LinkedList<>();

    /**
     * Number of "takeout packs" (e.g. cutlery and condiments) to deliver with the order.
     * For environmental reasons, customers should be encouraged to set this to 0.
     */
    @JsonInclude(Include.NON_NULL)
    public Integer takeoutPacks;

    /** Extra charges associated with the order, e.g. tax, discounts. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<OrderCharge> orderCharges = new LinkedList<>();

    /** The order's creation timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date created;

    /**
     * When should the order be submitted to the restaurant (null means now).
     * Used in future ordering.
     */
    @JsonInclude(Include.NON_NULL)
    public Date submitAt;

    /**
     * Timestamp in which the order was marked as "new" in the system. This may differ from the
     * order's creation timestamp for orders that were pending upon creation.
     */
    @JsonInclude(Include.NON_NULL)
    public Date received;

    /** The order's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date modified;

    /** The ordering user. */
    @JsonInclude(Include.NON_NULL)
    public User user;

    /** The ordering club member. */
    @JsonInclude(Include.NON_NULL)
    public ClubMember clubMember;

    /**
     * The order's status.
     * @see com.wix.restaurants.orders.Statuses
     */
    @JsonInclude(Include.NON_NULL)
    public String status;

    /** Allows retrieving a partially anonymized version of the order (used for publicly sharing the order). */
    @JsonInclude(Include.NON_NULL)
    public String shareToken;

    /** Allows retrieving the full order as the owner. */
    @JsonInclude(Include.NON_NULL)
    public String ownerToken;

    /** Affiliate-id, for orders that came through affiliate marketing. */
    @JsonInclude(Include.NON_NULL)
    public String affiliate;

    /** The client's developer id. */
    @JsonInclude(Include.NON_NULL)
    public String developer;

    /**
     * The organization-id from which the customer ordered.
     * @see com.wix.restaurants.Sources
     */
    @JsonInclude(Include.NON_NULL)
    public String source;

    /**
     * The platform through which the customer ordered.
     * @see com.wix.restaurants.Platforms
     */
    @JsonInclude(Include.NON_NULL)
    public String platform;

    /** The coupon which the customer used when when ordered. */
    @JsonInclude(Include.NON_NULL)
    public Coupon coupon;

    /**
     * Whether or not the order was submitted and should be displayed with a
     * legacy "2-level hierarchy".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean legacyHierarchy = Boolean.FALSE;

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();

    /** Change log for this order. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<LogEntry> log = new LinkedList<>();

    /**
     * The return url input parameter for the gateway to use when additional 3ds2 authentication is required.
     */
    @JsonInclude(Include.NON_NULL)
    public String gatewayReturnUrl;

    /** The location id which the customer used when ordered **/
    @JsonInclude(Include.NON_NULL)
    public String locationId;

    /** The loyalty summarize that the costumer used when ordered **/
    @JsonInclude(Include.NON_NULL)
    public Loyalty loyalty;

    /** The pos info used when ordered **/
    @JsonInclude(Include.NON_NULL)
    public PosInfo posInfo;
}
