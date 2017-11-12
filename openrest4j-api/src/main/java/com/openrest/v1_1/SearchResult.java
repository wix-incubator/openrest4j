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
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<TopItem> topItems = new LinkedList<>();
    
    /** Supported delivery types (optimization to avoid getting the entire deliveryInfos field). */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> deliveryTypes = new LinkedHashSet<>();
    
    /** The "most optimistic" delivery info (optimization to avoid getting the entire deliveryInfos field). */
    @JsonInclude(Include.NON_NULL)
    public DispatchInfo deliveryInfo;
}
