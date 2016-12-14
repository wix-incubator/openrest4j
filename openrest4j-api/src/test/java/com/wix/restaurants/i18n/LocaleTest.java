package com.wix.restaurants.i18n;

import com.wix.restaurants.json.Json;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocaleTest {
    @Test
    public void testStandardLocales() {
        final java.util.Locale en_US_java = java.util.Locale.US;
        final Locale en_US = Locale.fromJavaLocale(en_US_java);
        assertEquals("en_US", en_US.toString());
        assertEquals(en_US_java, en_US.toJavaLocale());

        final java.util.Locale fr_FR_java = java.util.Locale.FRANCE;
        final Locale fr_FR = Locale.fromJavaLocale(fr_FR_java);
        assertEquals("fr_FR", fr_FR.toString());
        assertEquals(fr_FR_java, fr_FR.toJavaLocale());
    }

    @Test
    public void testInitializationFromJavaLanguageTag() {
        final java.util.Locale en_US_java = java.util.Locale.US;
        assertEquals(new Locale(en_US_java.toString()), new Locale(en_US_java.toLanguageTag()));
    }

    @Test
    public void testProblematicLocales() {
        final java.util.Locale he_IL_java = new java.util.Locale("he", "IL");
        final Locale he_IL = Locale.fromJavaLocale(he_IL_java);
        assertEquals("he_IL", he_IL.toString());
        assertEquals(he_IL_java, he_IL.toJavaLocale());

        final java.util.Locale id_ID_java = new java.util.Locale("id", "ID");
        final Locale id_ID = Locale.fromJavaLocale(id_ID_java);
        assertEquals("id_ID", id_ID.toString());
        assertEquals(id_ID_java, id_ID.toJavaLocale());

        final java.util.Locale yi_IL_java = new java.util.Locale("yi", "IL");
        final Locale yi_IL = Locale.fromJavaLocale(yi_IL_java);
        assertEquals("yi_IL", yi_IL.toString());
        assertEquals(yi_IL_java, yi_IL.toJavaLocale());
    }

    @Test
    public void testStandardLocalesJson() {
        final Locale en_US = new Locale("en_US");
        final String en_US_json = Json.stringify(en_US);
        assertEquals("\"en_US\"", en_US_json);
        assertEquals(en_US, Json.parse(en_US_json, Locale.class));

        final Locale fr_FR = new Locale("fr_FR");
        final String fr_FR_json = Json.stringify(fr_FR);
        assertEquals("\"fr_FR\"", fr_FR_json);
        assertEquals(fr_FR, Json.parse(fr_FR_json, Locale.class));
    }

    @Test
    public void testProblematicLocalesJson() {
        final Locale he_IL = new Locale("he_IL");
        final String he_IL_json = Json.stringify(he_IL);
        assertEquals("\"he_IL\"", he_IL_json);
        assertEquals(he_IL, Json.parse(he_IL_json, Locale.class));

        final Locale id_ID = new Locale("id_ID");
        final String id_ID_json = Json.stringify(id_ID);
        assertEquals("\"id_ID\"", id_ID_json);
        assertEquals(id_ID, Json.parse(id_ID_json, Locale.class));

        final Locale yi_IL = new Locale("yi_IL");
        final String yi_IL_json = Json.stringify(yi_IL);
        assertEquals("\"yi_IL\"", yi_IL_json);
        assertEquals(yi_IL, Json.parse(yi_IL_json, Locale.class));
    }
}