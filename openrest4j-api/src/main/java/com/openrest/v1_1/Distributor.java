package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.i18n.LocalizedString;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Distributor extends Organization {
	public static final String TYPE = "distributor";
	
	private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Distributor() {}
    
    public Distributor(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
					   LocalizedString title, LocalizedString description,
					   Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages, ColorScheme colorScheme,
					   Contact contact, Map<String, Contact> externalContacts, Address address, String timezone, String currency,
					   List<AppInfo> apps, Seo seo,
					   Map<String, String> properties, Map<String, String> compatibilities,
					   Map<String, Availability> availabilities, String facebookAppId, String tld,
					   Map<String, Blob> blobs,
					   String state, Boolean closed, Set<Product> products, Double rank) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, externalContacts, address, timezone, currency, apps, seo, properties,
				compatibilities, availabilities, blobs, state, closed, products, rank);
    	
    	this.facebookAppId = facebookAppId;
    	this.tld = tld;
    }
    
    /**
     * The distributor's Facebook application id.
     * Deprecated, to be removed on 2014-08-01 (use externalIds["com.facebook.apps"])
     */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public String facebookAppId;
    
    /**
     * The distributor's top-level domain.
     * White-label systems use domains of the form {alias}.{tld}).
     */
    @JsonInclude(Include.NON_NULL)
    public String tld;
    
    @Override
	public Object clone() {
    	return new Distributor(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                (created != null) ? (Date) created.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
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
    			facebookAppId, tld, Blob.clone(blobs),
    			state, closed, Product.clone(products), rank);
	}
}
