package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Distributor information.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Distributor extends Organization {
	public static final String TYPE = "distributor";
	
	private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Distributor() {}
    
    public Distributor(String id, Map<String, String> externalIds, Long created, Long modified,
    		Map<String, String> title, Map<String, String> description,
    		String locale, Set<String> locales, Map<String, Map<String, String>> messages, ColorScheme colorScheme,
    		Contact contact, Map<String, Contact> externalContacts, Address address, String timezone, String currency,
    		String link, String domain, Set<String> altDomains,
    		List<AppInfo> apps, Seo seo, Map<String, String> properties, String facebookAppId,
    		String picture, String icon, String wideLogo, String noImagePicture, Double rank) {
    	super(id, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, externalContacts, address, timezone, currency, link, domain, altDomains, apps, seo, properties,
    			picture, icon, wideLogo, noImagePicture, rank);
    	
    	this.facebookAppId = facebookAppId;
    }
    
    /** The distributor's Facebook application id. */
    @JsonInclude(Include.NON_NULL)
    public String facebookAppId;
    
    @Override
	public Object clone() {
    	final Map<String, Map<String, String>> clonedMessages;
    	if (messages != null) {
    		clonedMessages = new HashMap<String, Map<String, String>>(messages.size());
    		for (Entry<String, Map<String, String>> entry : messages.entrySet()) {
    			clonedMessages.put(entry.getKey(), new HashMap<String, String>(entry.getValue()));
    		}
    	} else {
    		clonedMessages = null;
    	}
    	
    	final List<AppInfo> clonedApps;
    	if (apps != null) {
    		clonedApps = new ArrayList<AppInfo>(apps.size());
    		for (AppInfo app : apps) {
    			clonedApps.add((AppInfo) app.clone());
    		}
    	} else {
    		clonedApps = null;
    	}
    	
    	final Map<String, Contact> clonedExternalContacts;
    	if (externalContacts != null) {
    		clonedExternalContacts = new LinkedHashMap<String, Contact>(externalContacts.size());
    		for (Entry<String, Contact> entry : externalContacts.entrySet()) {
    			clonedExternalContacts.put(entry.getKey(), (Contact) entry.getValue().clone());
    		}
    	} else {
    		clonedExternalContacts = null;
    	}    	
    	
    	return new Distributor(id,
    			((externalIds != null) ? new HashMap<String, String>(externalIds) : null),    			
    			created, modified,
    			((title != null) ? new HashMap<String, String>(title) : null),
    			((description != null) ? new HashMap<String, String>(description) : null),
    			locale,
    			((locales != null) ? new HashSet<String>(locales) : null),
    			clonedMessages,
    			((colorScheme != null) ? (ColorScheme)colorScheme.clone() : null),
    			((contact != null) ? (Contact) contact.clone() : null), clonedExternalContacts,
    			((address != null) ? (Address) address.clone() : null),
    			timezone, currency, link, domain,
    			((altDomains != null) ? new HashSet<String>(altDomains) : null),
    			clonedApps,
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new HashMap<String, String>(properties) : null),
    			facebookAppId, picture, icon, wideLogo, noImagePicture, rank);
	}
}
