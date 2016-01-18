package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.OrderCharge;
import com.openrest.olo.dispatches.Dispatch;
import com.openrest.olo.payments.Payment;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /**
     * The order has been submitted by the user, and awaits her final approval.
     * The restaurant is not made aware of the order.
     */
    public static final String ORDER_STATUS_SUBMITTED = "submitted";
    /**
     * The restaurant required further confirmation before the order is submitted
     * (e.g. validating the user's phone number by SMS).
     */
    public static final String ORDER_STATUS_PENDING = "pending";
    /** The order has been approved by the user, and awaits processing by the restaurant. */
    public static final String ORDER_STATUS_NEW = "new";
    /** The order has been processed and accepted by the restaurant. */
    public static final String ORDER_STATUS_ACCEPTED = "accepted";
    /** The order has been canceled. */
    public static final String ORDER_STATUS_CANCELLED = "canceled";
    
    /** All known order statuses. */
    public static final Set<String> ALL_ORDER_STATUSES = new HashSet<>(Arrays.asList(new String[] {
    		ORDER_STATUS_SUBMITTED, ORDER_STATUS_PENDING, ORDER_STATUS_NEW, ORDER_STATUS_ACCEPTED, ORDER_STATUS_CANCELLED
    }));
    
    /** View the order as the restaurant. */
    public static final String ORDER_VIEW_MODE_RESTAURANT = "restaurant";
    /** View the order as the customer. */
    public static final String ORDER_VIEW_MODE_CUSTOMER = "customer";
    /** View the order as privately shared on social networks. */
    public static final String ORDER_VIEW_MODE_SHARE = "share";
    /** View the order as third-party source, e.g. portal. */
    public static final String ORDER_VIEW_MODE_SOURCE = "source";
    
    /** All known order view modes. */
    public static final Set<String> ALL_ORDER_VIEW_MODES = new HashSet<String>(Arrays.asList(new String[] {
    		ORDER_VIEW_MODE_RESTAURANT, ORDER_VIEW_MODE_CUSTOMER, ORDER_VIEW_MODE_SHARE, ORDER_VIEW_MODE_SOURCE
    }));

    /** Constructs a previously submitted order from persisted data. */
    public Order(String id, Map<String, String> externalIds, String distributorId, String chainId, String restaurantId,
    		String locale, List<OrderItem> orderItems,
    		String comment, Integer price, Dispatch delivery, Contact contact, List<Payment> payments,
            Integer takeoutPacks, List<Charge> charges, List<OrderCharge> orderCharges,
            java.util.Date created, java.util.Date received, java.util.Date modified, java.util.Date submitAt,
            User user, ClubMember clubMember, String status, String shareToken, String ownerToken,
            String affiliate, String developer, String source, String platform, String ref,
            Boolean legacyHierarchy, Map<String, String> properties, List<LogEntry> log) {

        this.id = id;
        this.externalIds = externalIds;
        this.distributorId = distributorId;
        this.chainId = chainId;
        this.restaurantId = restaurantId;
        this.locale = locale;
        this.orderItems = orderItems;
        this.comment = comment;
        this.price = price;
        this.delivery = delivery;
        this.contact = contact;
        this.payments = payments;
        this.takeoutPacks = takeoutPacks;
        this.charges = charges;
        this.orderCharges = orderCharges;
        this.created = ((created != null) ? created.getTime() : null);
        this.received = ((received != null) ? received.getTime() : null);
        this.modified = ((modified != null) ? modified.getTime() : null);
        this.submitAt = ((submitAt != null) ? submitAt.getTime() : null);
        this.user = user;
        this.clubMember = clubMember;
        this.status = status;
        this.shareToken = shareToken;
        this.ownerToken = ownerToken;
        this.affiliate = affiliate;
        this.developer = developer;
        this.source = source;
        this.platform = platform;
        this.ref = ref;
        this.legacyHierarchy = legacyHierarchy;
        this.properties = properties;
        this.log = log;
    }

    /** Default constructor for JSON deserialization. */
    public Order() {}
    
    @Override
	public Object clone() {
    	return new Order(id,
    			((externalIds != null) ? new LinkedHashMap<String, String>(externalIds) : null),
    			distributorId, chainId, restaurantId, locale, OrderItem.clone(orderItems), comment, price,
    			((delivery != null) ? (Dispatch) delivery.clone() : null),
    			((contact != null) ? (Contact) contact.clone() : null),
    			Payment.clone(payments), takeoutPacks, Charge.clone(charges), OrderCharge.clone(orderCharges),
    			created(), received(), modified(), submitAt(),
    			((user != null) ? (User) user.clone() : null),
    			((clubMember != null) ? (ClubMember) clubMember.clone() : null),
    			status, shareToken, ownerToken, affiliate, developer, source, platform, ref, legacyHierarchy,
    			((properties != null) ? new LinkedHashMap<String, String>(properties) : null),
    			LogEntry.clone(log));
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (affiliate != null ? !affiliate.equals(order.affiliate) : order.affiliate != null) return false;
        if (chainId != null ? !chainId.equals(order.chainId) : order.chainId != null) return false;
        if (charges != null ? !charges.equals(order.charges) : order.charges != null) return false;
        if (clubMember != null ? !clubMember.equals(order.clubMember) : order.clubMember != null) return false;
        if (comment != null ? !comment.equals(order.comment) : order.comment != null) return false;
        if (contact != null ? !contact.equals(order.contact) : order.contact != null) return false;
        if (created != null ? !created.equals(order.created) : order.created != null) return false;
        if (delivery != null ? !delivery.equals(order.delivery) : order.delivery != null) return false;
        if (developer != null ? !developer.equals(order.developer) : order.developer != null) return false;
        if (distributorId != null ? !distributorId.equals(order.distributorId) : order.distributorId != null) return false;
        if (externalIds != null ? !externalIds.equals(order.externalIds) : order.externalIds != null) return false;
        if (html != null ? !html.equals(order.html) : order.html != null) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (legacyHierarchy != null ? !legacyHierarchy.equals(order.legacyHierarchy) : order.legacyHierarchy != null) return false;
        if (locale != null ? !locale.equals(order.locale) : order.locale != null) return false;
        if (log != null ? !log.equals(order.log) : order.log != null) return false;
        if (modified != null ? !modified.equals(order.modified) : order.modified != null) return false;
        if (orderCharges != null ? !orderCharges.equals(order.orderCharges) : order.orderCharges != null) return false;
        if (orderItems != null ? !orderItems.equals(order.orderItems) : order.orderItems != null) return false;
        if (payments != null ? !payments.equals(order.payments) : order.payments != null) return false;
        if (platform != null ? !platform.equals(order.platform) : order.platform != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        if (properties != null ? !properties.equals(order.properties) : order.properties != null) return false;
        if (received != null ? !received.equals(order.received) : order.received != null) return false;
        if (ref != null ? !ref.equals(order.ref) : order.ref != null) return false;
        if (restaurantId != null ? !restaurantId.equals(order.restaurantId) : order.restaurantId != null) return false;
        if (shareToken != null ? !shareToken.equals(order.shareToken) : order.shareToken != null) return false;
        if (ownerToken != null ? !ownerToken.equals(order.ownerToken) : order.ownerToken != null) return false;
        if (source != null ? !source.equals(order.source) : order.source != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (submitAt != null ? !submitAt.equals(order.submitAt) : order.submitAt != null) return false;
        if (takeoutPacks != null ? !takeoutPacks.equals(order.takeoutPacks) : order.takeoutPacks != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        result = 31 * result + (distributorId != null ? distributorId.hashCode() : 0);
        result = 31 * result + (chainId != null ? chainId.hashCode() : 0);
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (delivery != null ? delivery.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (payments != null ? payments.hashCode() : 0);
        result = 31 * result + (takeoutPacks != null ? takeoutPacks.hashCode() : 0);
        result = 31 * result + (charges != null ? charges.hashCode() : 0);
        result = 31 * result + (orderCharges != null ? orderCharges.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (submitAt != null ? submitAt.hashCode() : 0);
        result = 31 * result + (received != null ? received.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (clubMember != null ? clubMember.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (shareToken != null ? shareToken.hashCode() : 0);
        result = 31 * result + (ownerToken != null ? ownerToken.hashCode() : 0);
        result = 31 * result + (affiliate != null ? affiliate.hashCode() : 0);
        result = 31 * result + (developer != null ? developer.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (ref != null ? ref.hashCode() : 0);
        result = 31 * result + (legacyHierarchy != null ? legacyHierarchy.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        result = 31 * result + (log != null ? log.hashCode() : 0);
        result = 31 * result + (html != null ? html.hashCode() : 0);
        return result;
    }

    public java.util.Date created() {
        return ((created != null) ? new java.util.Date(created.longValue()) : null);
    }
    
    public java.util.Date received() {
        return ((received != null) ? new java.util.Date(received.longValue()) : null);
    }

    public java.util.Date modified() {
        return ((modified != null) ? new java.util.Date(modified.longValue()) : null);
    }
    
    public java.util.Date submitAt() {
        return ((submitAt != null) ? new java.util.Date(submitAt.longValue()) : null);
    }

    /** The order's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<String, String>();

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
    public String locale;

    /** The ordered items. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<OrderItem> orderItems = new LinkedList<>();

    /** Comment to the restaurant (as opposed to the delivery person!). */
    @JsonInclude(Include.NON_NULL)
    public String comment;

    /** Total price of the order. */
    @JsonInclude(Include.NON_NULL)
    public Integer price;

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
    
    /**
	 * Extra charges or discounts associated with the order, ordered by priority
	 * in descending order.
	 * 
     * Scheduled for deprecation on 2015-04-01 (use orderCharges). 
	 */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new LinkedList<Charge>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<OrderCharge> orderCharges = new LinkedList<OrderCharge>();

    /** The order's creation timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long created;
    
    /**
     * When should the order be submitted to the restaurant (null means now).
     * Used in future ordering.
     */
    @JsonInclude(Include.NON_NULL)
    public Long submitAt;
    
    /**
     * Timestamp in which the order was marked as "new" in the system. This may differ from the
     * order's creation timestamp for orders that were pending upon creation.
     */
    @JsonInclude(Include.NON_NULL)
    public Long received;

    /** The order's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long modified;

    /** The ordering user. */
    @JsonInclude(Include.NON_NULL)
    public User user;
    
    /** The ordering club member. */
    @JsonInclude(Include.NON_NULL)
    public ClubMember clubMember;

    /** The order's status. */
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
     * An empty String means the restaurant's (or chain's) white-label system.
     */
    @JsonInclude(Include.NON_NULL)
    public String source;
    
    /** @see AppId#ALL_PLATFORMS */
    @JsonInclude(Include.NON_NULL)
    public String platform;
    
    /**
     * Affiliate-specific referrer-id for performance tracking, e.g. 
     * Facebook campaign id, iPhone application id, self-service station id.
     */
    @JsonInclude(Include.NON_NULL)
    public String ref;
    
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
    public Map<String, String> properties = new LinkedHashMap<String, String>();
    
    /** Change log for this order. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<LogEntry> log = new LinkedList<LogEntry>();
    
    /** The order in HTML format. */
    @JsonInclude(Include.NON_NULL)
    public String html;
}
