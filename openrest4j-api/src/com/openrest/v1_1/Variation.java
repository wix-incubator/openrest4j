package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A possible modification to an item, e.g. "choice of sides" for a happy-meal
 * or "degree of cooking" for a hamburger.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variation implements Serializable {
    public static final String VARIATION_DISPLAY_TYPE_DIFF = "diff";
    public static final String VARIATION_DISPLAY_TYPE_CHOICE = "choice";
    /**
     * Variations that are not displayed to the customer, just to the restaurant.
     * Similar to a hidden field in an HTML form.
     */
    public static final String VARIATION_DISPLAY_TYPE_HIDDEN = "hidden";
    
    /** All known variation display types. */
    public static final Set<String> ALL_VARIATION_DISPLAY_TYPES = new HashSet<String>(
    		Arrays.asList(VARIATION_DISPLAY_TYPE_DIFF, VARIATION_DISPLAY_TYPE_CHOICE, VARIATION_DISPLAY_TYPE_HIDDEN));

    public Variation(Map<String, String> title, String tagId, Integer minNumAllowed,
    		Integer maxNumAllowed, Map<String, Integer> prices, Set<String> defaults, String displayType) {
        this.title = title;
        this.tagId = tagId;
        this.minNumAllowed = minNumAllowed;
        this.maxNumAllowed = maxNumAllowed;
        this.prices = prices;
        this.defaults = defaults;
        this.displayType = displayType;
    }

    /** Default constructor for JSON deserialization. */
    public Variation() {}

    /** The variations's name in various locales, e.g. "sides", "degree of cooking". */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new HashMap<String, String>();

    /** The set's name, e.g. "drink", "sides". */
    @JsonInclude(Include.NON_NULL)
    public String tagId;

    /** Minimum number of items to select. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer minNumAllowed = 0;

    /** Maximum number of items to select. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer maxNumAllowed = Integer.MAX_VALUE;

    /** Items' base prices. Non-referenced items are free by default. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Integer> prices = new HashMap<String, Integer>();

    /** Default selected item ids. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> defaults = new HashSet<String>();

    /** Display type for human-readable printing. */
    @JsonInclude(Include.NON_DEFAULT)
    public String displayType = VARIATION_DISPLAY_TYPE_CHOICE;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variation other = (Variation) obj;
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if ((this.tagId == null) ? (other.tagId != null) : !this.tagId.equals(other.tagId)) {
            return false;
        }
        if (this.minNumAllowed != other.minNumAllowed && (this.minNumAllowed == null || !this.minNumAllowed.equals(other.minNumAllowed))) {
            return false;
        }
        if (this.maxNumAllowed != other.maxNumAllowed && (this.maxNumAllowed == null || !this.maxNumAllowed.equals(other.maxNumAllowed))) {
            return false;
        }
        if (this.prices != other.prices && (this.prices == null || !this.prices.equals(other.prices))) {
            return false;
        }
        if (this.defaults != other.defaults && (this.defaults == null || !this.defaults.equals(other.defaults))) {
            return false;
        }
        if ((this.displayType == null) ? (other.displayType != null) : !this.displayType.equals(other.displayType)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 97 * hash + (this.tagId != null ? this.tagId.hashCode() : 0);
        hash = 97 * hash + (this.minNumAllowed != null ? this.minNumAllowed.hashCode() : 0);
        hash = 97 * hash + (this.maxNumAllowed != null ? this.maxNumAllowed.hashCode() : 0);
        hash = 97 * hash + (this.prices != null ? this.prices.hashCode() : 0);
        hash = 97 * hash + (this.defaults != null ? this.defaults.hashCode() : 0);
        hash = 97 * hash + (this.displayType != null ? this.displayType.hashCode() : 0);
        return hash;
    }
    
    private static final long serialVersionUID = 1L;
}
