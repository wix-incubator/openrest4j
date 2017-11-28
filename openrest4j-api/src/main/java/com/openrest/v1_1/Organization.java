package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.i18n.LocalizedString;

import java.util.*;
import java.util.Map.Entry;

/** Base class for Restaurants, Chains, Portals, Distributors. */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Organization extends OpenrestObject implements Cloneable, Comparable<Organization> {
	private static final long serialVersionUID = 1L;

    /**
     * External-id key for specifying the organization's notifications ("no-reply") email.
     * For the value's format, @see <a href="http://en.wikipedia.org/wiki/Email_address">Email address</a>
     *
     * @see Organization#externalIds
     */
    public static final String EXTERNAL_ID_EMAIL_NOREPLY = "email.noreply";

    /** The organization's welcome message. */
    public static final String MESSAGE_TYPE_WELCOME = "welcome";
    /** The organization's order confirmation message. */
    public static final String MESSAGE_TYPE_ORDER_CONFIRMATION = "order_confirmation";
    /** The organization's ToS (terms of service). */
    public static final String MESSAGE_TYPE_TERMS = "terms";
    
    /** Default constructor for JSON deserialization. */
    public Organization() {}
    
    protected Organization(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
                           LocalizedString title, LocalizedString description,
                           Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages, ColorScheme colorScheme,
                           Contact contact, Map<String, Contact> externalContacts,
                           Address address, String timezone, String currency,
                           List<AppInfo> apps, Seo seo, Map<String, String> properties,
                           Map<String, String> compatibilities, Map<String, Availability> availabilities,
                           Map<String, Blob> blobs,
                           String state, Boolean closed, Set<Product> products, Double rank) {

    	this.id = id;
    	this.alias = alias;
    	this.affiliateId = affiliateId;
    	this.externalIds = externalIds;
    	this.created = created;
    	this.modified = modified;
    	this.title = title;
    	this.description = description;
    	this.locale = locale;
    	this.locales = locales;
    	this.messages = messages;
    	this.colorScheme = colorScheme;
    	this.contact = contact;
    	this.externalContacts = externalContacts;
    	this.address = address;
    	this.timezone = timezone;
    	this.currency = currency;
    	this.apps = apps;
    	this.seo = seo;
    	this.properties = properties;
    	this.compatibilities = compatibilities;
        this.availabilities = availabilities;
    	this.blobs = blobs;
    	this.state = state;
    	this.closed = closed;
    	this.products = products;
    	this.rank = rank;
    }
    
    @Override
	public Object clone() {
        return cloneImpl();
    }

    protected abstract Organization cloneImpl();
    
    protected static Map<String, LocalizedString> cloneMessages(Map<String, LocalizedString> messages) {
    	if (messages == null) {
    		return null;
    	}
    	
    	final Map<String, LocalizedString> cloned = new LinkedHashMap<>(messages.size());
		for (Entry<String, LocalizedString> entry : messages.entrySet()) {
			cloned.put(entry.getKey(), (entry.getValue() != null) ? (LocalizedString) entry.getValue().clone() : null);
		}
		return cloned;
    }
    
    /** The organization's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /**
     * The organization's current alias.
     *
     * Scheduled for deprecation on 2017-12-01.
     */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public String alias;
    
    /** The organization's referrer. */
    @JsonInclude(Include.NON_NULL)
    public String affiliateId;
    
    /**
     * Map of externally-defined ids referring to this organization.
     * For example, the organization-id in some external billing system.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<>();
    
    /** The organization's creation timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date created;
    
    /** The organization's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date modified;
    
    /** The organization's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;

    /** The organization's description or tagline in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString description = LocalizedString.empty;
    
    /**
     * The color scheme.
     *
     * Scheduled for deprecation on 2017-12-01.
     */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public ColorScheme colorScheme;

    /** The organization's contact. */
    @JsonInclude(Include.NON_NULL)
    public Contact contact;
    
    /**
     * Map of externally-defined contact information for this organization.
     * For example, a redirect phone number in some portal.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     *
     * Scheduled for deprecation on 2017-12-01.
     */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Contact> externalContacts = new LinkedHashMap<>();

    /** The address of this organization. */
    @JsonInclude(Include.NON_NULL)
    public Address address;
    
    /**
     * The restaurant's timezone.
     * @see <a href="http://en.wikipedia.org/wiki/List_of_tz_database_time_zones">List of tz database time zones</a>
     * 
     * Use java.util.TimeZone.getTimeZone to create a Java TimeZone object.
     */
    @JsonInclude(Include.NON_NULL)
    public String timezone;
    
    /** The organization's currency (ISO 4217). */
    @JsonInclude(Include.NON_NULL)
    public String currency;
    
    /** The organization's default locale, e.g. "en_US". */
    @JsonInclude(Include.NON_NULL)
    public Locale locale;
    
    /** The organization's supported locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<Locale> locales = new LinkedHashSet<>();
    
    /**
     * Maps message types (e.g. MESSAGE_TYPE_WELCOME) to their text in various locales.
     * The text may contain simple HTML formatting.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, LocalizedString> messages = new LinkedHashMap<>();
    
    /** The organization's applications. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<AppInfo> apps = new LinkedList<>();
    
    /** SEO information. */
    @JsonInclude(Include.NON_NULL)
    public Seo seo;
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
    
    /**
     * Maps features to compatibility levels, e.g. "com.openrest.charges" to "1.0.0".
     * A non-existent key means "latest".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> compatibilities = new LinkedHashMap<>();

    /**
     * Availabilities of various aspects in the system, e.g. online ordering.
     * A non-existent key means "unavailable".
     * @see com.wix.restaurants.Aspects for possible keys.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Availability> availabilities = new LinkedHashMap<>();

    /**
     * Maps blob-types to blobs.
     * @see BlobTypes
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Blob> blobs = new LinkedHashMap<>();
    
    /**
     * The organization is permanently closed, e.g. out of business.
     * To mark an organization is temporarily closed (e.g. for renovation), use openTimes.exceptions
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean closed = Boolean.FALSE;
    
    /**
     * @see State#ALL_STATES
     *
     * Scheduled for deprecation on 2017-12-01.
     */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public String state = State.STATE_OPERATIONAL;
    
    /** Active products */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<Product> products = new LinkedHashSet<>();
    
    /** The organization's popularity rank (higher is better). */
    @JsonInclude(Include.NON_NULL)
    public Double rank;
    
    public static int compareRank(Double rank1, Double rank2) {
		if (rank1 != null) {
			return ((rank2 != null) ? -rank1.compareTo(rank2) : -1);
		} else {
			return ((rank2 == null) ? (0) : 1);
		}
    }
    
	public int compareTo(Organization other) {
		int result = compareRank(rank, other.rank);
		if (result == 0) {
			result = State.compare(state, other.state);
		}
		return result;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (alias != null ? !alias.equals(that.alias) : that.alias != null) return false;
        if (affiliateId != null ? !affiliateId.equals(that.affiliateId) : that.affiliateId != null) return false;
        if (externalIds != null ? !externalIds.equals(that.externalIds) : that.externalIds != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (modified != null ? !modified.equals(that.modified) : that.modified != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (colorScheme != null ? !colorScheme.equals(that.colorScheme) : that.colorScheme != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (externalContacts != null ? !externalContacts.equals(that.externalContacts) : that.externalContacts != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (locale != null ? !locale.equals(that.locale) : that.locale != null) return false;
        if (locales != null ? !locales.equals(that.locales) : that.locales != null) return false;
        if (messages != null ? !messages.equals(that.messages) : that.messages != null) return false;
        if (apps != null ? !apps.equals(that.apps) : that.apps != null) return false;
        if (seo != null ? !seo.equals(that.seo) : that.seo != null) return false;
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) return false;
        if (compatibilities != null ? !compatibilities.equals(that.compatibilities) : that.compatibilities != null) return false;
        if (availabilities != null ? !availabilities.equals(that.availabilities) : that.availabilities != null) return false;
        if (blobs != null ? !blobs.equals(that.blobs) : that.blobs != null) return false;
        if (closed != null ? !closed.equals(that.closed) : that.closed != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (products != null ? !products.equals(that.products) : that.products != null) return false;
        return rank != null ? rank.equals(that.rank) : that.rank == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (affiliateId != null ? affiliateId.hashCode() : 0);
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (colorScheme != null ? colorScheme.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (externalContacts != null ? externalContacts.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + (locales != null ? locales.hashCode() : 0);
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        result = 31 * result + (apps != null ? apps.hashCode() : 0);
        result = 31 * result + (seo != null ? seo.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        result = 31 * result + (compatibilities != null ? compatibilities.hashCode() : 0);
        result = 31 * result + (availabilities != null ? availabilities.hashCode() : 0);
        result = 31 * result + (blobs != null ? blobs.hashCode() : 0);
        result = 31 * result + (closed != null ? closed.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }
}
