package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Information regarding an app in the appstore (in a given locale). */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppstoreInfo implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public AppstoreInfo(String title, String description, Set<String> keywords,
    		String supportUrl, String marketingUrl, String privacyPolicyUrl) {
    	this.title = title;
    	this.description = description;
    	this.keywords = keywords;
    	this.supportUrl = supportUrl;
    	this.marketingUrl = marketingUrl;
    	this.privacyPolicyUrl = privacyPolicyUrl;
    }

    /** Default constructor for JSON deserialization. */
    public AppstoreInfo() {}
    
    @Override
	public Object clone() {
    	return new AppstoreInfo(title, description, keywords, supportUrl, marketingUrl, privacyPolicyUrl);
	}
    
    /** The app's title. */
    @JsonInclude(Include.NON_NULL)
    public String title;
    
    /** The app's description (multi-line). */
    @JsonInclude(Include.NON_NULL)
    public String description;
    
    /** Search-related keywords. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> keywords = new HashSet<String>();
    
    /** Support URL. */
    @JsonInclude(Include.NON_NULL)
    public String supportUrl;
    
    /** Support URL. */
    @JsonInclude(Include.NON_NULL)
    public String marketingUrl;
    
    /** Support URL. */
    @JsonInclude(Include.NON_NULL)
    public String privacyPolicyUrl;
}
