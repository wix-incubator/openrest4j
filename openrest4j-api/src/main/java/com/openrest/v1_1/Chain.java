package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chain extends Organization {
	public static final String TYPE = "chain";
	
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Chain() {}
    
    public Chain(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
    		String distributorId, Map<Locale, String> title, Map<Locale, String> description,
    		Locale locale, Set<Locale> locales, Map<String, Map<Locale, String>> messages, ColorScheme colorScheme,
    		Contact contact, Map<String, Contact> externalContacts, Address address, String timezone, String currency,
    		String link, String domain, Set<String> altDomains,
    		List<AppInfo> apps, Seo seo, Map<String, String> properties,
			Map<String, String> compatibilities, Map<String, Availability> availabilities,
    		String picture, String icon, String wideLogo, String noImagePicture, Map<String, Blob> blobs,
    		String state, Boolean closed, String virtualId, Boolean inactive, Set<Product> products, Double rank) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, externalContacts, address, timezone, currency, link, domain, altDomains, apps, seo, properties,
				compatibilities, availabilities, picture, icon, wideLogo, noImagePicture, blobs, state, closed, virtualId, inactive, products, rank);
    	
    	this.distributorId = distributorId;
    }
    
    @Override
	public Object clone() {
    	return new Chain(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
				(created != null) ? (Date) created.clone() : null,
				(modified != null) ? (Date) modified.clone() : null,
				distributorId,
    			((title != null) ? new LinkedHashMap<>(title) : null),
    			((description != null) ? new LinkedHashMap<>(description) : null),
    			locale,
    			((locales != null) ? new LinkedHashSet<>(locales) : null),
    			cloneMessages(messages),
    			((colorScheme != null) ? (ColorScheme)colorScheme.clone() : null),
    			((contact != null) ? (Contact) contact.clone() : null), Contact.clone(externalContacts),
    			((address != null) ? (Address) address.clone() : null),
    			timezone, currency, link, domain,
    			((altDomains != null) ? new LinkedHashSet<>(altDomains) : null),
    			AppInfo.clone(apps),
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			((compatibilities != null) ? new LinkedHashMap<>(compatibilities) : null),
				Availability.clone(availabilities),
    			picture, icon, wideLogo, noImagePicture, Blob.clone(blobs),
    			state, closed, virtualId, inactive, Product.clone(products), rank);
	}
    
    /** The distributor in charge of this chain. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
}
