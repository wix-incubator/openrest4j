package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.i18n.LocalizedString;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chain extends Organization {
	public static final String TYPE = "chain";
	
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Chain() {}
    
    public Chain(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
				 String distributorId, LocalizedString title, LocalizedString description,
				 Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages, ColorScheme colorScheme,
				 Contact contact, Map<String, Contact> externalContacts, Address address, String timezone, String currency,
				 List<AppInfo> apps, Seo seo, Map<String, String> properties,
				 Map<String, String> compatibilities, Map<String, Availability> availabilities,
				 Map<String, Blob> blobs,
				 String state, Boolean closed, Set<Product> products, Double rank) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, externalContacts, address, timezone, currency, apps, seo, properties,
				compatibilities, availabilities, blobs, state, closed, products, rank);
    	
    	this.distributorId = distributorId;
    }
    
    @Override
	protected Chain cloneImpl() {
    	return new Chain(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
				(created != null) ? (Date) created.clone() : null,
				(modified != null) ? (Date) modified.clone() : null,
				distributorId,
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
				Availability.clone(availabilities), Blob.clone(blobs),
    			state, closed, Product.clone(products), rank);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Chain chain = (Chain) o;

		return distributorId != null ? distributorId.equals(chain.distributorId) : chain.distributorId == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (distributorId != null ? distributorId.hashCode() : 0);
		return result;
	}

	/** The distributor in charge of this chain. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
}
