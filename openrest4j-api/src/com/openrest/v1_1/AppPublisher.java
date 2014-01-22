package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** AppStore application publisher .*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppPublisher implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
    /**
     * External-id key for specifying the publisher's Play Store developer account.
     * Taken from https://play.google.com/apps/publish/?dev_acc=[XXX]
     * 
     * @see AppPublisher.externalIds
     */
    public static final String EXTERNAL_ID_GOOGLE_PLAY = "com.google.play";
    
    /**
     * External-id key for specifying the publisher's Google Maps "Key for Android applications".
     * Taken from https://cloud.google.com/console/project/XXX/apiui/credential
     * 
     * @see AppPublisher.externalIds
     */
    public static final String EXTERNAL_ID_GOOGLE_MAPS_ANDROID = "com.google.maps.android";
    
    /**
     * Used to sign Android apps.
     * @see AppPublisher.certificates
     */
    public static final String CERTIFICATE_ANDROID = "android";
    
    /**
     * Used to sign iOS apps.
     * @see AppPublisher.externalIds
     */
    public static final String CERTIFICATE_IOS = "ios";
    
    /**
     * Used to sign iOS apps.
     * @see AppPublisher.externalIds
     */
    public static final String CERTIFICATE_IOS_PRIVATE = "ios.private";
    
    /** 
     * Apple (developer id).
     * @see AppPublisher.logins
     */
    public static final String LOGIN_APPLE = "com.apple";
    
    /** 
     * Urban Airship.
     * @see AppPublisher.logins
     */
    public static final String LOGIN_URBANAIRSHIP = "com.urbanairship";
    
    public AppPublisher(String title, String url, Contact contact, String copyright, Map<String, String> externalIds,
    		Map<String, Login> logins, Map<String, Certificate> certificates) {
    	this.title = title;
    	this.url = url;
    	this.contact = contact;
    	this.copyright = copyright;
    	this.externalIds = externalIds;
    	this.logins = logins;
    	this.certificates = certificates;
    }
    
    /** Default constructor for JSON deserialization. */
    public AppPublisher() {}
    
    @Override
	public Object clone() {
    	final Map<String, Login> clonedLogins;
    	if (logins != null) {
    		clonedLogins = new HashMap<String, Login>(logins.size());
    		for (Entry<String, Login> entry : logins.entrySet()) {
    			clonedLogins.put(entry.getKey(), (Login) entry.getValue().clone());
    		}
    	} else {
    		clonedLogins = null;
    	}
    	
    	final Map<String, Certificate> clonedCertificates;
    	if (certificates != null) {
    		clonedCertificates = new HashMap<String, Certificate>(certificates.size());
    		for (Entry<String, Certificate> entry : certificates.entrySet()) {
    			clonedCertificates.put(entry.getKey(), (Certificate) entry.getValue().clone());
    		}
    	} else {
    		clonedCertificates = null;
    	}
    	
    	return new AppPublisher(title, url,
    			((contact != null) ? (Contact) contact.clone() : null),
    			copyright,
    			((externalIds != null) ? new HashMap<String, String>(externalIds) : null),
    			clonedLogins, clonedCertificates);
	}
    
    @JsonInclude(Include.NON_NULL)
    public String title;
    
    @JsonInclude(Include.NON_NULL)
    public String url;
    
    @JsonInclude(Include.NON_NULL)
    public Contact contact;
    
    @JsonInclude(Include.NON_NULL)
    public String copyright;
    
    /**
     * Map of externally-defined ids referring to this publisher.
     * For example, the publisher-id in some app store.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new HashMap<String, String>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Login> logins = new HashMap<String, Login>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Certificate> certificates = new HashMap<String, Certificate>();
}
