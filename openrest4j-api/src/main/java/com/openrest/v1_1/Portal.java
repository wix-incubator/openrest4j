package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.i18n.LocalizedString;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Portal extends Organization {
	public static final String TYPE = "portal";
	
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Portal() {}
    
    public Portal(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
				  String distributorId, Filter filter,
				  LocalizedString title, LocalizedString description,
				  Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages, ColorScheme colorScheme,
				  Contact contact, Map<String, Contact> externalContacts, Address address, String timezone, String currency,
				  List<AppInfo> apps, Seo seo, Map<String, String> properties,
				  Map<String, String> compatibilities, Map<String, Availability> availabilities,
				  String picture, String icon, String wideLogo, String noImagePicture, Map<String, Blob> blobs,
				  String state, Boolean closed, Set<Product> products, Double rank,
				  List<PortalMenuCategory> categories) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, externalContacts, address, timezone, currency, apps, seo, properties,
				compatibilities, availabilities, picture, icon, wideLogo, noImagePicture, blobs, state, closed, products, rank);
    	
    	this.distributorId = distributorId;
    	this.filter = filter;
    	this.categories = categories;
    }
    
    @Override
	public Object clone() {
    	return new Portal(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
				(created != null) ? (Date) created.clone() : null,
				(modified != null) ? (Date) modified.clone() : null,
				distributorId,
    			((filter != null) ? (Filter) filter.clone() : null),
    			((title != null) ? (LocalizedString) title.clone() : null),
    			((description != null) ? (LocalizedString) description.clone() : null),
    			locale,
    			((locales != null) ? new LinkedHashSet<>(locales) : null),
    			cloneMessages(messages),
    			((colorScheme != null) ? (ColorScheme)colorScheme.clone() : null),
    			((contact != null) ? (Contact) contact.clone() : null), Contact.clone(externalContacts),
    			((address != null) ? (Address) address.clone() : null),
    			timezone, currency, AppInfo.clone(apps),
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			((compatibilities != null) ? new LinkedHashMap<>(compatibilities) : null),
				Availability.clone(availabilities),
    			picture, icon, wideLogo, noImagePicture, Blob.clone(blobs),
    			state, closed, Product.clone(products), rank, PortalMenuCategory.cloneList(categories));
	}
    
    /** The distributor in charge of this portal. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    /** The filter associated with this portal. */
    @JsonInclude(Include.NON_DEFAULT)
    public Filter filter = new Filter();
    
    /** The filter associated with this portal. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<PortalMenuCategory> categories = new LinkedList<>();
}
