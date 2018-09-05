package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
				  String distributorId,
				  LocalizedString title, LocalizedString description,
				  Locale locale, Set<Locale> locales, Map<String, LocalizedString> messages,
				  Contact contact, Address address, String timezone, String currency,
				  List<AppInfo> apps, Map<String, String> properties,
				  Map<String, String> media, Boolean closed, Set<Product> products, List<PortalMenuCategory> categories) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages,
    			contact, address, timezone, currency, apps, properties,
				media, closed, products);
    	
    	this.distributorId = distributorId;
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
    			((title != null) ? title.clone() : null),
    			((description != null) ? description.clone() : null),
    			locale,
    			((locales != null) ? new LinkedHashSet<>(locales) : null),
    			cloneMessages(messages),
    			((contact != null) ? contact.clone() : null),
    			((address != null) ? address.clone() : null),
    			timezone, currency, AppInfo.clone(apps),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
                ((media != null) ? new LinkedHashMap<>(media) : null),
    			closed, Product.clone(products), PortalMenuCategory.cloneList(categories));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Portal portal = (Portal) o;
		return Objects.equals(distributorId, portal.distributorId) &&
				Objects.equals(categories, portal.categories);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), distributorId, categories);
	}

	/** The distributor in charge of this portal. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    /** The portal's categories. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<PortalMenuCategory> categories = new LinkedList<>();
}
