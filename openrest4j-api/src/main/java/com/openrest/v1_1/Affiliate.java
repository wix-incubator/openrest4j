package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.i18n.LocalizedString;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Affiliate extends Organization {
	public static final String TYPE = "affiliate";
	
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Affiliate() {}
    
    public Affiliate(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
					 String distributorId, LocalizedString title, LocalizedString description,
					 Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages, ColorScheme colorScheme,
					 Contact contact, Address address, String timezone, String currency,
					 List<AppInfo> apps, Seo seo, Map<String, String> properties,
					 Map<String, String> compatibilities, Map<String, Availability> availabilities,
					 Map<String, Blob> blobs, String state, Boolean closed, Set<Product> products) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, address, timezone, currency, apps, seo, properties,
				compatibilities, availabilities, blobs, state, closed, products);
    	
    	this.distributorId = distributorId;
    }

    @Override
    public Affiliate clone() {
        return cloneImpl();
    }

    @Override
	protected Affiliate cloneImpl() {
    	return new Affiliate(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                (created != null) ? (Date) created.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
				distributorId,
    			((title != null) ? title.clone() : null),
    			((description != null) ? description.clone() : null),
    			locale,
    			((locales != null) ? new LinkedHashSet<>(locales) : null),
    			cloneMessages(messages),
    			((colorScheme != null) ? (ColorScheme)colorScheme.clone() : null),
    			((contact != null) ? contact.clone() : null),
    			((address != null) ? address.clone() : null),
    			timezone, currency, AppInfo.clone(apps),
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			((compatibilities != null) ? new LinkedHashMap<>(compatibilities) : null),
				Availability.clone(availabilities), Blob.clone(blobs),
    			state, closed, Product.clone(products));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Affiliate affiliate = (Affiliate) o;

		return distributorId != null ? distributorId.equals(affiliate.distributorId) : affiliate.distributorId == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (distributorId != null ? distributorId.hashCode() : 0);
		return result;
	}

    /** The distributor in charge of this affiliate. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
}
