package com.wix.restaurants.i18n;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/** Am immutable localized string. */
@JsonSerialize(using = LocalizedStringSerializer.class)
@JsonDeserialize(using = LocalizedStringDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalizedString implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    public static final LocalizedString empty = new LocalizedString(Collections.<Locale, String>emptyMap());

    private Map<Locale, String> localized;

    public LocalizedString(Map<Locale, String> localized) {
        this.localized = localized;
    }

    /** Default constructor for JSON deserialization. */
    public LocalizedString() {}

    public String get(Locale locale) {
        return localized.get(locale);
    }

    public Map<Locale, String> getLocalized() {
        return localized;
    }

    @Override
    public LocalizedString clone() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalizedString that = (LocalizedString) o;
        return Objects.equals(localized, that.localized);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localized);
    }

    @Override
    public String toString() {
        return localized.toString();
    }
}
