package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Availability;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult extends Restaurant {
    private static final long serialVersionUID = 1L;
    
    public SearchResult(String id, Map<String, String> externalIds, Long created, Long modified,
    		String distributorId, String chainId, Map<String, String> title,
    		Map<String, String> description, Contact contact, Map<String, Contact> externalContacts, Address address,
    		Map<String, Map<String, String>> messages, ColorScheme colorScheme,
    		Availability openTimes, Availability deliveryTimes,
            Boolean inactive, List<DeliveryInfo> deliveryInfos, Integer maxFutureOrderDelayMins,
            String timezone, String currency, String locale, Set<String> locales,
            Set<String> paymentTypes, Map<String, CardInfo> cardInfos, Map<String, Integer> minPayments,
            String link, String domain, Set<String> altDomains,
            String picture, String icon, String wideLogo, String noImagePicture, Map<String, Blob> blobs,
            List<AppInfo> apps, Seo seo, Map<String, String> properties,
            String state, Map<String, Double> features, Boolean legacyHierarchy, Double rank, List<TopItem> topItems,
            Set<String> deliveryTypes, DeliveryInfo deliveryInfo, List<Charge> charges) {
    	super(id, externalIds, created, modified, distributorId, chainId, title, description, contact, externalContacts,
    			address, messages, colorScheme, openTimes, deliveryTimes, inactive, deliveryInfos, maxFutureOrderDelayMins,
    			timezone, currency, locale, locales, paymentTypes, cardInfos, minPayments, link, domain, altDomains,
    			picture, icon, wideLogo, noImagePicture, blobs,
    			apps, seo, properties, state, features, legacyHierarchy, rank);
    	
    	this.topItems = topItems;
    	this.deliveryTypes = deliveryTypes;
    	this.deliveryInfo = deliveryInfo;
    	this.charges = charges;
    }
    
    /** Default constructor for JSON deserialization. */
    public SearchResult() {}
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<TopItem> topItems = new ArrayList<TopItem>();
    
    /** Supported delivery types (optimization to avoid getting the entire deliveryInfos field). */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> deliveryTypes = new HashSet<String>();
    
    /** The "most optimistic" delivery info (optimization to avoid getting the entire deliveryInfos field). */
    @JsonInclude(Include.NON_NULL)
    public DeliveryInfo deliveryInfo;
    
    /** Available charges (for discounts search). */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new ArrayList<Charge>();
}
