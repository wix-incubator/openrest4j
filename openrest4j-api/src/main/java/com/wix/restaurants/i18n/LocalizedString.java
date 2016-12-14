package com.wix.restaurants.i18n;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/** Am immutable localized string. */
@JsonSerialize(using = LocalizedStringSerializer.class)
@JsonDeserialize(using = LocalizedStringDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalizedString implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    public static LocalizedString empty = new LocalizedString(Collections.<Locale, String>emptyMap());

    private Map<Locale, String> localized;

    public LocalizedString(Map<Locale, String> localized) {
        this.localized = localized;
    }

    /** Default constructor for JSON deserialization. */
    public LocalizedString() {}

    public Map<Locale, String> getLocalized() {
        return localized;
    }

    @Override
    public Object clone() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalizedString that = (LocalizedString) o;

        return localized != null ? localized.equals(that.localized) : that.localized == null;
    }

    @Override
    public int hashCode() {
        return localized != null ? localized.hashCode() : 0;
    }

    @Override
    public String toString() {
        return localized.toString();
    }
}
