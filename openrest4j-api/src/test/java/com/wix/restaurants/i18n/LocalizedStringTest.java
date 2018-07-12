package com.wix.restaurants.i18n;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wix.restaurants.json.Json;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LocalizedStringTest {
    @Test
    public void testJson() {
        final Map<Locale, String> localized = new LinkedHashMap<>();
        localized.put(Locale.fromJavaLocale(java.util.Locale.US), "English string with special characters: \"{},\\");
        localized.put(Locale.fromJavaLocale(new java.util.Locale("he", "IL")), "מחרוזת בעברית");

        final LocalizedString lstr = new LocalizedString(localized);
        final String json = Json.stringify(lstr);
        final LocalizedString parsed = Json.parse(json, LocalizedString.class);
        assertEquals(lstr, parsed);
    }
 
    @Test
    public void testJsonDeserializationToBasicTypes() {
        final Locale en_US = Locale.fromJavaLocale(java.util.Locale.US);
        final Locale he_IL = Locale.fromJavaLocale(new java.util.Locale("he", "IL"));

        final Map<Locale, String> localized = new LinkedHashMap<>();
        localized.put(en_US, "English string with special characters: \"{},\\");
        localized.put(he_IL, "מחרוזת בעברית");

        final LocalizedString lstr = new LocalizedString(localized);
        final String json = Json.stringify(lstr);

        final Map<String, String> parsed = Json.parse(json, new TypeReference<Map<String, String>>() {});
        assertEquals(2, parsed.size());
        assertEquals(parsed.get("en_US"), localized.get(en_US));
        assertEquals(parsed.get("he_IL"), localized.get(he_IL));
    }
}