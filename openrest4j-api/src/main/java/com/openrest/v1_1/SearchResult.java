package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult extends Restaurant {
    private static final long serialVersionUID = 1L;
    
    public SearchResult(String id, String alias, String affiliateId, Map<String, String> externalIds, Long created, Long modified,
    		String distributorId, String chainId, Map<String, String> title,
    		Map<String, String> description, Contact contact, Map<String, Contact> externalContacts, Address address,
    		Map<String, Map<String, String>> messages, ColorScheme colorScheme,
    		Availability openTimes, Availability deliveryTimes,
            List<DeliveryInfo> deliveryInfos, Integer maxFutureOrderDelayMins,
            String timezone, String currency, String locale, Set<String> locales,
            Set<String> paymentTypes, Boolean multiPaymentDisabled, Map<String, CardInfo> cardInfos,
            Map<String, Integer> minPayments, Boolean antiFraudDisabled, String link, String domain, Set<String> altDomains,
            String picture, String icon, String wideLogo, String noImagePicture, Map<String, Blob> blobs,
            List<AppInfo> apps, Seo seo, Map<String, String> properties,
            Map<String, String> compatibilities, Map<String, Availability> availabilities,
            String state, Boolean closed, String virtualId, Boolean inactive, Set<Product> products,
            Map<String, Double> features, Double rank, List<TopItem> topItems,
            Set<String> deliveryTypes, DeliveryInfo deliveryInfo, List<Charge> charges) {
    	super(id, alias, affiliateId, externalIds, created, modified, distributorId, chainId, title, description, contact, externalContacts,
    			address, messages, colorScheme, openTimes, deliveryTimes, deliveryInfos, maxFutureOrderDelayMins,
    			timezone, currency, locale, locales, paymentTypes, multiPaymentDisabled, cardInfos, minPayments,
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
    public DeliveryInfo deliveryInfo;
    
    /** Available charges (for discounts search). */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new LinkedList<>();
}
