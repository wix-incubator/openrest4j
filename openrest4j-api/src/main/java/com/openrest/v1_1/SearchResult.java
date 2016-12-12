package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.dispatches.DispatchInfo;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.reservations.ReservationsInfo;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult extends Restaurant {
    private static final long serialVersionUID = 1L;
    
    public SearchResult(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
                        String distributorId, String chainId, Map<Locale, String> title,
                        Map<Locale, String> description, Contact contact, Map<String, Contact> externalContacts, Address address,
                        Map<String, Map<Locale, String>> messages, ColorScheme colorScheme,
                        Availability openTimes, Availability deliveryTimes,
                        List<DispatchInfo> deliveryInfos, Integer maxFutureOrderDelayMins,
                        String timezone, String currency, Locale locale, Set<Locale> locales,
                        Set<String> paymentTypes, Boolean multiPaymentDisabled, Map<String, CardInfo> cardInfos, CreditcardsInfo creditcardsInfo,
                        DeliveriesInfo deliveriesInfo, ReservationsInfo reservations, Map<String, Integer> minPayments, Boolean antiFraudDisabled, String link, String domain,
                        Set<String> altDomains, String picture, String icon, String wideLogo, String noImagePicture, Map<String, Blob> blobs,
                        List<AppInfo> apps, Seo seo, Map<String, String> properties,
                        Map<String, String> compatibilities, Map<String, Availability> availabilities,
                        String state, Boolean closed, String virtualId, Boolean inactive, Set<Product> products,
                        Map<String, Double> features, Double rank, List<TopItem> topItems,
                        Set<String> deliveryTypes, DispatchInfo deliveryInfo, List<Charge> charges) {
    	super(id, alias, affiliateId, externalIds, created, modified, distributorId, chainId, title, description, contact, externalContacts,
    			address, messages, colorScheme, openTimes, deliveryTimes, deliveryInfos, maxFutureOrderDelayMins,
    			timezone, currency, locale, locales, paymentTypes, multiPaymentDisabled, cardInfos, creditcardsInfo, deliveriesInfo, reservations, minPayments,
    			antiFraudDisabled, link, domain, altDomains, picture, icon, wideLogo, noImagePicture, blobs,
    			apps, seo, properties, compatibilities, availabilities, state, closed, virtualId, inactive, products, features, rank);
    	
    	this.topItems = topItems;
    	this.deliveryTypes = deliveryTypes;
    	this.deliveryInfo = deliveryInfo;
    	this.charges = charges;
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
    
    /** Available charges (for discounts search). */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new LinkedList<>();
}
