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
                           Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages,
                           Contact contact, Address address, String timezone, String currency,
                           List<AppInfo> apps, Seo seo, Map<String, String> properties,
                           Map<String, String> compatibilities, Map<String, Availability> availabilities,
                           Map<String, String> media, Boolean closed, Set<Product> products) {

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
    	this.contact = contact;
    	this.address = address;
    	this.timezone = timezone;
    	this.currency = currency;
    	this.apps = apps;
    	this.seo = seo;
    	this.properties = properties;
    	this.compatibilities = compatibilities;
        this.availabilities = availabilities;
    	this.media = media;
    	this.closed = closed;
    	this.products = products;
    }
    
    @Override
	public Organization clone() {
        return cloneImpl();
    }

    protected abstract Organization cloneImpl();
    
    protected static Map<String, LocalizedString> cloneMessages(Map<String, LocalizedString> messages) {
    	if (messages == null) {
    		return null;
    	}
    	
    	final Map<String, LocalizedString> cloned = new LinkedHashMap<>(messages.size());
		for (Entry<String, LocalizedString> entry : messages.entrySet()) {
			cloned.put(entry.getKey(), (entry.getValue() != null) ? entry.getValue().clone() : null);
		}
		return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(alias, that.alias) &&
                Objects.equals(affiliateId, that.affiliateId) &&
                Objects.equals(externalIds, that.externalIds) &&
                Objects.equals(created, that.created) &&
                Objects.equals(modified, that.modified) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(address, that.address) &&
                Objects.equals(timezone, that.timezone) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(locale, that.locale) &&
                Objects.equals(locales, that.locales) &&
                Objects.equals(messages, that.messages) &&
                Objects.equals(apps, that.apps) &&
                Objects.equals(seo, that.seo) &&
                Objects.equals(properties, that.properties) &&
                Objects.equals(compatibilities, that.compatibilities) &&
                Objects.equals(availabilities, that.availabilities) &&
                Objects.equals(media, that.media) &&
                Objects.equals(closed, that.closed) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alias, affiliateId, externalIds, created, modified, title, description, contact, address, timezone, currency, locale, locales, messages, apps, seo, properties, compatibilities, availabilities, media, closed, products);
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
    
    /** The organization's contact. */
    @JsonInclude(Include.NON_NULL)
    public Contact contact;

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
     * Maps media-types to URLs.
     * @see BlobTypes
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> media = new LinkedHashMap<>();

    /**
     * The organization is permanently closed, e.g. out of business.
     * To mark an organization is temporarily closed (e.g. for renovation), use openTimes.exceptions
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean closed = Boolean.FALSE;
    
    /** Active products */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<Product> products = new LinkedHashSet<>();
    
	public int compareTo(Organization other) {
	    return this.id.compareTo(other.id);
	}


    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                ", affiliateId='" + affiliateId + '\'' +
                ", externalIds=" + externalIds +
                ", created=" + created +
                ", modified=" + modified +
                ", title=" + title +
                ", description=" + description +
                ", contact=" + contact +
                ", address=" + address +
                ", timezone='" + timezone + '\'' +
                ", currency='" + currency + '\'' +
                ", locale=" + locale +
                ", locales=" + locales +
                ", messages=" + messages +
                ", apps=" + apps +
                ", seo=" + seo +
                ", properties=" + properties +
                ", compatibilities=" + compatibilities +
                ", availabilities=" + availabilities +
                ", media=" + media +
                ", closed=" + closed +
                ", products=" + products +
                '}';
    }
}
