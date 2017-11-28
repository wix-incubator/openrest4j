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
                        LocalizedString description, Contact contact, Map<String, Contact> externalContacts, Address address,
                        Map<String, LocalizedString> messages, ColorScheme colorScheme,
                        Availability openTimes, List<DispatchInfo> deliveryInfos,
                        String timezone, String currency, Locale locale, Set<Locale> locales,
                        Set<String> paymentTypes, Boolean multiPaymentDisabled, CreditcardsInfo creditcardsInfo,
                        DeliveriesInfo deliveriesInfo, OrdersInfo orders, ReservationsInfo reservations,
                        Boolean antiFraudDisabled, Map<String, Blob> blobs,
                        List<AppInfo> apps, Seo seo, Map<String, String> properties,
                        Map<String, String> compatibilities, Map<String, Availability> availabilities,
                        String state, Boolean closed, Set<Product> products,
                        Map<String, Double> features, Double rank, List<TopItem> topItems,
                        Set<String> deliveryTypes, DispatchInfo deliveryInfo) {
    	super(id, alias, affiliateId, externalIds, created, modified, distributorId, chainId, title, description, contact, externalContacts,
    			address, messages, colorScheme, openTimes, deliveryInfos,
    			timezone, currency, locale, locales, paymentTypes, multiPaymentDisabled, creditcardsInfo, deliveriesInfo, orders, reservations,
    			antiFraudDisabled, blobs, apps, seo, properties, compatibilities, availabilities, state, closed, products, features, rank);
    	
    	this.topItems = topItems;
    	this.deliveryTypes = deliveryTypes;
    	this.deliveryInfo = deliveryInfo;
    }
    
    /** Default constructor for JSON deserialization. */
    public SearchResult() {}

    @Override
    protected SearchResult cloneImpl() {
        return new SearchResult(id, alias, affiliateId,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                (created != null) ? (Date) created.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
                distributorId, chainId,
                ((title != null) ? (LocalizedString) title.clone() : null),
                ((description != null) ? (LocalizedString) description.clone() : null),
                ((contact != null) ? (Contact)contact.clone() : null), Contact.clone(externalContacts),
                ((address != null) ? (Address)address.clone() : null),
                cloneMessages(messages),
                ((colorScheme != null) ? (ColorScheme) colorScheme.clone() : null),
                ((openTimes != null) ? (Availability) openTimes.clone() : null),
                DispatchInfo.clone(deliveryInfos),
                timezone, currency, locale,
                ((locales != null) ? new LinkedHashSet<>(locales) : null),
                ((paymentTypes != null) ? new LinkedHashSet<>(paymentTypes) : null),
                multiPaymentDisabled,
                ((creditcardsInfo != null) ? (CreditcardsInfo) creditcardsInfo.clone() : null),
                ((deliveriesInfo != null) ? (DeliveriesInfo) deliveriesInfo.clone() : null),
                ((orders != null) ? (OrdersInfo) orders.clone() : null),
                ((reservations != null) ? (ReservationsInfo) reservations.clone() : null),
                antiFraudDisabled, Blob.clone(blobs), AppInfo.clone(apps),
                ((seo != null) ? (Seo) seo.clone() : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                ((compatibilities != null) ? new LinkedHashMap<>(compatibilities) : null),
                Availability.clone(availabilities),
                state, closed, Product.clone(products),
                ((features != null) ? new LinkedHashMap<>(features) : null),
                rank,
                TopItem.clone(topItems),
                (deliveryTypes != null) ? new LinkedHashSet<>(deliveryTypes): null,
                (deliveryInfo != null) ? (DispatchInfo) deliveryInfo.clone() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SearchResult that = (SearchResult) o;

        if (topItems != null ? !topItems.equals(that.topItems) : that.topItems != null) return false;
        if (deliveryTypes != null ? !deliveryTypes.equals(that.deliveryTypes) : that.deliveryTypes != null) return false;
        return deliveryInfo != null ? deliveryInfo.equals(that.deliveryInfo) : that.deliveryInfo == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (topItems != null ? topItems.hashCode() : 0);
        result = 31 * result + (deliveryTypes != null ? deliveryTypes.hashCode() : 0);
        result = 31 * result + (deliveryInfo != null ? deliveryInfo.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_DEFAULT)
    public List<TopItem> topItems = new LinkedList<>();
    
    /** Supported delivery types (optimization to avoid getting the entire deliveryInfos field). */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> deliveryTypes = new LinkedHashSet<>();
    
    /** The "most optimistic" delivery info (optimization to avoid getting the entire deliveryInfos field). */
    @JsonInclude(Include.NON_NULL)
    public DispatchInfo deliveryInfo;
}
