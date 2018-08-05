package com.wix.restaurants.i18n;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Objects;

/**
 * An immutable locale string, e.g. "en_US", "fr_FR".
 *
 * This class is a workaround for java.util.Locale's non-standard representations of Hebrew ("iw" instead of "he"),
 * Indonesian ("in" instead of "id"), and Yiddish ("ji" instead of "yi").
 */
@JsonSerialize(using = ToStringSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Locale implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    private String languageTag;

    /**
     * @param languageTag   IETF language tag
     * @see <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a>
     */
    public Locale(String languageTag) {
        this.languageTag = toLanguageTag(languageTag);
    }

    public static Locale fromJavaLocale(java.util.Locale javaLocale) {
        return new Locale(javaLocale.toLanguageTag());
    }

    /** Default constructor for JSON deserialization. */
    public Locale() {}

    public java.util.Locale toJavaLocale() {
        return java.util.Locale.forLanguageTag(languageTag);
    }

    @Override
    public Locale clone() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locale locale = (Locale) o;
        return Objects.equals(languageTag, locale.languageTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageTag);
    }

    @Override
    public String toString() {
        return toJavaLanguageTag(languageTag);
    }

    private static String toJavaLanguageTag(String languageTag) {
        return languageTag.replaceAll("-", "_");
    }
    private static String toLanguageTag(String javaLanguageTag) {
        return javaLanguageTag.replaceAll("_", "-");
    }
}
