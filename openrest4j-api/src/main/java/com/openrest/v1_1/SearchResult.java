package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.dispatches.DispatchInfo;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.i18n.LocalizedString;
import com.wix.restaurants.orders.OrdersInfo;
import com.wix.restaurants.reservations.ReservationsInfo;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult extends Restaurant {
    private static final long serialVersionUID = 1L;
    
    public SearchResult(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
                        String distributorId, String chainId, LocalizedString title,
                        LocalizedString description, Contact contact, Address address,
                        Map<String, LocalizedString> messages,
                        Availability openTimes, List<DispatchInfo> deliveryInfos,
                        String timezone, String currency, Locale locale, Set<Locale> locales,
                        Set<String> paymentTypes, Boolean multiPaymentDisabled, CreditcardsInfo creditcardsInfo,
                        DeliveriesInfo deliveriesInfo, OrdersInfo orders, ReservationsInfo reservations,
                        Map<String, String> media, List<AppInfo> apps, Map<String, String> properties,
                        Boolean closed, Set<Product> products,
                        Map<String, Double> features, Set<String> deliveryTypes, DispatchInfo deliveryInfo) {
    	super(id, alias, affiliateId, externalIds, created, modified, distributorId, chainId, title, description, contact,
    			address, messages, openTimes, deliveryInfos,
    			timezone, currency, locale, locales, paymentTypes, multiPaymentDisabled, creditcardsInfo, deliveriesInfo, orders, reservations,
    			media, apps, properties, closed, products, features);

    	this.deliveryTypes = deliveryTypes;
    	this.deliveryInfo = deliveryInfo;
    }
    
    /** Default constructor for JSON deserialization. */
    public SearchResult() {}

    @Override
    public SearchResult clone() {
        return cloneImpl();
    }

    @Override
    protected SearchResult cloneImpl() {
        return new SearchResult(id, alias, affiliateId,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                (created != null) ? (Date) created.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
                distributorId, chainId,
                ((title != null) ? title.clone() : null),
                ((description != null) ? description.clone() : null),
                ((contact != null) ? contact.clone() : null),
                ((address != null) ? address.clone() : null),
                cloneMessages(messages),
                ((openTimes != null) ? openTimes.clone() : null),
                DispatchInfo.clone(deliveryInfos),
                timezone, currency, locale,
                ((locales != null) ? new LinkedHashSet<>(locales) : null),
                ((paymentTypes != null) ? new LinkedHashSet<>(paymentTypes) : null),
                multiPaymentDisabled,
                ((creditcardsInfo != null) ? creditcardsInfo.clone() : null),
                ((deliveriesInfo != null) ? deliveriesInfo.clone() : null),
                ((orders != null) ? orders.clone() : null),
                ((reservations != null) ? reservations.clone() : null),
                ((media != null) ? new LinkedHashMap<>(media) : null),
                AppInfo.clone(apps),
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                closed, Product.clone(products),
                ((features != null) ? new LinkedHashMap<>(features) : null),
                (deliveryTypes != null) ? new LinkedHashSet<>(deliveryTypes): null,
                (deliveryInfo != null) ? deliveryInfo.clone() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SearchResult that = (SearchResult) o;
        return Objects.equals(deliveryTypes, that.deliveryTypes) &&
                Objects.equals(deliveryInfo, that.deliveryInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deliveryTypes, deliveryInfo);
    }

    /** Supported delivery types (optimization to avoid getting the entire deliveryInfos field). */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> deliveryTypes = new LinkedHashSet<>();
    
    /** The "most optimistic" delivery info (optimization to avoid getting the entire deliveryInfos field). */
    @JsonInclude(Include.NON_NULL)
    public DispatchInfo deliveryInfo;
}
