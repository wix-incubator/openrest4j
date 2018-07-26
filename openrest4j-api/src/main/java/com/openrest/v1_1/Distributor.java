package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
					   Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages,
					   Contact contact, Address address, String timezone, String currency,
					   List<AppInfo> apps, Map<String, String> properties, Map<String, Availability> availabilities,
					   Map<String, String> media, Boolean closed, Set<Product> products) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages,
    			contact, address, timezone, currency, apps, properties,
				availabilities, media, closed, products);
    }

    @Override
    public Distributor clone() {
        return cloneImpl();
    }

	@Override
	protected Distributor cloneImpl() {
		return new Distributor(id, alias, affiliateId,
				((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
				(created != null) ? (Date) created.clone() : null,
				(modified != null) ? (Date) modified.clone() : null,
				((title != null) ? title.clone() : null),
				((description != null) ? description.clone() : null),
				locale,
				((locales != null) ? new LinkedHashSet<>(locales) : null),
				cloneMessages(messages),
				((contact != null) ? contact.clone() : null),
				((address != null) ? address.clone() : null),
				timezone, currency, AppInfo.clone(apps),
				((properties != null) ? new LinkedHashMap<>(properties) : null),
				Availability.clone(availabilities),
				((media != null) ? new LinkedHashMap<>(media) : null),
				closed, Product.clone(products));
	}
}
