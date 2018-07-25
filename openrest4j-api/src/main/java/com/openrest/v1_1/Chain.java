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
				 Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages,
				 Contact contact, Address address, String timezone, String currency,
				 List<AppInfo> apps, Seo seo, Map<String, String> properties,
				 Map<String, Availability> availabilities,
				 Map<String, String> media, Boolean closed, Set<Product> products) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages,
    			contact, address, timezone, currency, apps, seo, properties,
				availabilities, media, closed, products);
    	
    	this.distributorId = distributorId;
    }

    @Override
    public Chain clone() {
        return cloneImpl();
    }

    @Override
	protected Chain cloneImpl() {
    	return new Chain(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
				(created != null) ? (Date) created.clone() : null,
				(modified != null) ? (Date) modified.clone() : null,
				distributorId,
    			((title != null) ? title.clone() : null),
    			((description != null) ? description.clone() : null),
    			locale,
    			((locales != null) ? new LinkedHashSet<>(locales) : null),
    			cloneMessages(messages),
    			((contact != null) ? contact.clone() : null),
    			((address != null) ? address.clone() : null),
    			timezone, currency, AppInfo.clone(apps),
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
				Availability.clone(availabilities),
				((media != null) ? new LinkedHashMap<>(media) : null),
    			closed, Product.clone(products));
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
