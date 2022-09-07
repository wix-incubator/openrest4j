package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;
import com.wix.restaurants.orders.VariationDisplayTypes;

import java.io.Serializable;
import java.util.*;

/**
 * A possible modification to an item, e.g. "choice of sides" for a happy-meal
 * or "degree of cooking" for a hamburger.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariationMetaData implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public VariationMetaData(String title, String description, String media) {
        this.title = title;
        this.media = media;
        this.description = description;
    }

    /** Default constructor for JSON deserialization. */
    public VariationMetaData() {}

    @Override
    public VariationMetaData clone() {
        return new VariationMetaData(title, description, media);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariationMetaData variationMetaData = (VariationMetaData) o;
        return Objects.equals(title, variationMetaData.title) &&
                Objects.equals(description, variationMetaData.description) &&
                Objects.equals(media, variationMetaData.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, media);
    }

    /** The item title. */
    @JsonInclude(Include.NON_DEFAULT)
    public String title;

    /** The item description. */
    @JsonInclude(Include.NON_DEFAULT)
    public String description;

    /** The item media. */
    @JsonInclude(Include.NON_NULL)
    public String media;
}