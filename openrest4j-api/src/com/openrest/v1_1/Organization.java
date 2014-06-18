package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Base class for Restaurants, Chains, Portals, Distributers. */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Organization extends OpenrestObject implements Cloneable, Comparable<Organization> {
	private static final long serialVersionUID = 1L;
	
    /** The organization's welcome message. */
    public static final String MESSAGE_TYPE_WELCOME = "welcome";
    /** The organization's order confirmation message. */
    public static final String MESSAGE_TYPE_ORDER_CONFIRMATION = "order_confirmation";
    /** The organization's ToS (terms of service). */
    public static final String MESSAGE_TYPE_TERMS = "terms";
    
    /**
     * External-id key for specifying the organization's notifications ("no-reply") email.
     * For the value's format, @see http://en.wikipedia.org/wiki/Email_address
     * 
     * @see Organization.externalIds
     */
    public static final String EXTERNAL_ID_EMAIL_NOREPLY = "email.noreply";
	
	/** Standard (4:3) logo image. */
    public static final String BLOB_TYPE_LOGO = "logo";
	/** Square (1:1) logo image. */
    public static final String BLOB_TYPE_LOGO_SQUARE = "logo_square";
	/** Wide (4:1) logo image. */
    public static final String BLOB_TYPE_LOGO_WIDE = "logo_wide";
	/** Standard (4:3) image place holder. */
    public static final String BLOB_TYPE_NO_IMAGE = "no_image";
	/** Cover (7:4) image. */
    public static final String BLOB_TYPE_COVER = "cover";
	/**
	 * Sound recording for automated phone calls.
	 * @see Notification.NOTIFICATION_TYPE_DELAYED_ORDER, Notification.NOTIFICATION_TYPE_NEW_ORDER
	 */
    public static final String BLOB_TYPE_NOTIFICATION_VOICE = "notification_voice";
	/**
	 * Sound recording for automated phone calls.
	 * @see Notification.NOTIFICATION_TYPE_POS_ERROR
	 */
    public static final String BLOB_TYPE_NOTIFICATION_POS_ERROR = "notification_pos_error";
    
    /** Default constructor for JSON deserialization. */
    public Organization() {}
    
    protected Organization(String id, String alias, String affiliateId, Map<String, String> externalIds, Long created, Long modified,
    		Map<String, String> title, Map<String, String> description,
    		String locale, Set<String> locales, Map<String, Map<String, String>> messages, ColorScheme colorScheme,
    		Contact contact, Map<String, Contact> externalContacts,
    		Address address, String timezone, String currency,
    		String link, String domain, Set<String> altDomains,
    		List<AppInfo> apps, Seo seo, Map<String, String> properties,
    		String picture, String icon, String wideLogo, String noImagePicture, Map<String, Blob> blobs,
    		String state, Boolean closed, String virtualId, Boolean inactive, Set<Product> products, Double rank) {

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
    	this.link = link;
    	this.domain = domain;
    	this.altDomains = altDomains;
    	this.apps = apps;
    	this.seo = seo;
    	this.properties = properties;
    	this.picture = picture;
    	this.icon = icon;
    	this.wideLogo = wideLogo;
    	this.noImagePicture = noImagePicture;
    	this.blobs = blobs;
    	this.state = state;
    	this.closed = closed;
    	this.virtualId = virtualId;
    	this.inactive = inactive;
    	this.products = products;
    	this.rank = rank;
    }
    
    @Override
	public abstract Object clone();
    
    protected static Map<String, Map<String, String>> cloneMessages(Map<String, Map<String, String>> messages) {
    	if (messages == null) {
    		return null;
    	}
    	
    	final Map<String, Map<String, String>> cloned = new LinkedHashMap<String, Map<String, String>>(messages.size());
		for (Entry<String, Map<String, String>> entry : messages.entrySet()) {
			cloned.put(entry.getKey(), (entry.getValue() != null) ? new LinkedHashMap<String, String>(entry.getValue()) : null);
		}
		return cloned;
    }
    
    public java.util.Date created() {
        return ((created != null) ? new java.util.Date(created.longValue()) : null);
    }
    
    public java.util.Date modified() {
        return ((modified != null) ? new java.util.Date(modified.longValue()) : null);
    }
    
    /** The organization's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** The organization's current alias. */
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
    public Map<String, String> externalIds = new HashMap<String, String>();
    
    /** The organization's creation timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long created;
    
    /** The organization's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long modified;
    
    /** The organization's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new HashMap<String, String>();

    /** The organization's description or tagline in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> description = new HashMap<String, String>();
    
    /** The color scheme. */
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
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Contact> externalContacts = new HashMap<String, Contact>();

    /** The address of this organization. */
    @JsonInclude(Include.NON_NULL)
    public Address address;
    
    /**
     * The restaurant's timezone.
     * @see http://en.wikipedia.org/wiki/List_of_tz_database_time_zones
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
    public String locale;
    
    /** The organization's supported locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> locales = new LinkedHashSet<String>();
    
    /**
     * Maps message types (e.g. MESSAGE_TYPE_WELCOME) to their text in various locales.
     * The text may contain simple HTML formatting.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Map<String, String>> messages = new HashMap<String, Map<String, String>>();
    
    /** The organization's main web-site URL. */
    @JsonInclude(Include.NON_NULL)
    public String link;
    
    /** The organization's online ordering domain. */
    @JsonInclude(Include.NON_NULL)
    public String domain;
    
    /**
     * The organization's online ordering alternative / legacy domains.
     * These should redirect to the main domain.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> altDomains = new LinkedHashSet<String>(); 
    
    /** The organization's picture URL (direct link), or null if unavailable. */
    @JsonInclude(Include.NON_NULL)
    public String picture;
    
    /** The organization's icon URL (direct link), or null if unavailable. */
    @JsonInclude(Include.NON_NULL)
    public String icon;
    
    /** The organization's wide logo URL (direct link), or null if unavailable. */
    @JsonInclude(Include.NON_NULL)
    public String wideLogo;
    
    /** The picture shown when a picture is missing. */
    @JsonInclude(Include.NON_NULL)
    public String noImagePicture;
    
    /** The organization's applications. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<AppInfo> apps = new ArrayList<AppInfo>();
    
    /** SEO information. */
    @JsonInclude(Include.NON_NULL)
    public Seo seo;
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
    
    /**
     * Maps blob-types to blobs.
     * @see GetBlobUploadUrlRequest#blobType
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Blob> blobs = new HashMap<String, Blob>();
    
    /**
     * The organization is permanently closed, e.g. out of business.
     * To mark an organization is temporarily closed (e.g. for renovation), use openTimes.exceptions
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean closed = Boolean.FALSE;
    
    /** For virtual organizations, marks the "real" organization id. */
    @JsonInclude(Include.NON_NULL)
    public String virtualId;
    
    /** Whether the organization has been activated (supplied billing information). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean inactive = Boolean.FALSE;
    
    /** @see State.ALL_STATES */
    @JsonInclude(Include.NON_DEFAULT)
    public String state = State.STATE_OPERATIONAL;
    
    /** Active products */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<Product> products = new LinkedHashSet<Product>();
    
    /** The organization's Openrest rank (higher is better). */
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
}
