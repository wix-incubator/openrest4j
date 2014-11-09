package com.openrest.v1_1;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chain extends Organization {
	public static final String TYPE = "chain";
	
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Chain() {}
    
    public Chain(String id, String alias, String affiliateId, Map<String, String> externalIds, Long created, Long modified,
    		String distributorId, Map<String, String> title, Map<String, String> description,
    		String locale, Set<String> locales, Map<String, Map<String, String>> messages, ColorScheme colorScheme,
    		Contact contact, Map<String, Contact> externalContacts, Address address, String timezone, String currency,
    		String link, String domain, Set<String> altDomains,
    		List<AppInfo> apps, Seo seo, Map<String, String> properties, Map<String, String> compatibilities,
    		String picture, String icon, String wideLogo, String noImagePicture, Map<String, Blob> blobs,
    		String state, Boolean closed, String virtualId, Boolean inactive, Set<Product> products, Double rank) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, externalContacts, address, timezone, currency, link, domain, altDomains, apps, seo, properties, compatibilities,
    			picture, icon, wideLogo, noImagePicture, blobs, state, closed, virtualId, inactive, products, rank);
    	
    	this.distributorId = distributorId;
    }
    
    @Override
	public Object clone() {
    	return new Chain(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<String, String>(externalIds) : null),
    			created, modified, distributorId,
    			((title != null) ? new LinkedHashMap<String, String>(title) : null),
    			((description != null) ? new LinkedHashMap<String, String>(description) : null),
    			locale,
    			((locales != null) ? new LinkedHashSet<String>(locales) : null),
    			cloneMessages(messages),
    			((colorScheme != null) ? (ColorScheme)colorScheme.clone() : null),
    			((contact != null) ? (Contact) contact.clone() : null), Contact.clone(externalContacts),
    			((address != null) ? (Address) address.clone() : null),
    			timezone, currency, link, domain,
    			((altDomains != null) ? new LinkedHashSet<String>(altDomains) : null),
    			AppInfo.clone(apps),
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new LinkedHashMap<String, String>(properties) : null),
    			((compatibilities != null) ? new LinkedHashMap<String, String>(compatibilities) : null),
    			picture, icon, wideLogo, noImagePicture, Blob.clone(blobs),
    			state, closed, virtualId, inactive, Product.clone(products), rank);
	}
    
    /** The distributor in charge of this chain. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
}
