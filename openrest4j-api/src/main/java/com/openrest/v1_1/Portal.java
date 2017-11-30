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
				  Map<String, String> compatibilities, Map<String, Availability> availabilities, Map<String, Blob> blobs,
				  String state, Boolean closed, Set<Product> products, Double rank,
				  List<PortalMenuCategory> categories) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, externalContacts, address, timezone, currency, apps, seo, properties,
				compatibilities, availabilities, blobs, state, closed, products, rank);
    	
    	this.distributorId = distributorId;
    	this.filter = filter;
    	this.categories = categories;
    }

    @Override
    public Portal clone() {
        return cloneImpl();
    }

    @Override
	protected Portal cloneImpl() {
    	return new Portal(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
				(created != null) ? (Date) created.clone() : null,
				(modified != null) ? (Date) modified.clone() : null,
				distributorId,
    			((filter != null) ? (Filter) filter.clone() : null),
    			((title != null) ? title.clone() : null),
    			((description != null) ? description.clone() : null),
    			locale,
    			((locales != null) ? new LinkedHashSet<>(locales) : null),
    			cloneMessages(messages),
    			((colorScheme != null) ? (ColorScheme)colorScheme.clone() : null),
    			((contact != null) ? contact.clone() : null), Contact.clone(externalContacts),
    			((address != null) ? address.clone() : null),
    			timezone, currency, AppInfo.clone(apps),
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			((compatibilities != null) ? new LinkedHashMap<>(compatibilities) : null),
				Availability.clone(availabilities), Blob.clone(blobs),
    			state, closed, Product.clone(products), rank, PortalMenuCategory.cloneList(categories));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Portal portal = (Portal) o;

		if (distributorId != null ? !distributorId.equals(portal.distributorId) : portal.distributorId != null) return false;
		if (filter != null ? !filter.equals(portal.filter) : portal.filter != null) return false;
		return categories != null ? categories.equals(portal.categories) : portal.categories == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (distributorId != null ? distributorId.hashCode() : 0);
		result = 31 * result + (filter != null ? filter.hashCode() : 0);
		result = 31 * result + (categories != null ? categories.hashCode() : 0);
		return result;
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
