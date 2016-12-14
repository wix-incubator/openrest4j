package com.wix.restaurants.i18n;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LocalizedStringDeserializer extends StdDeserializer<LocalizedString> {
    public LocalizedStringDeserializer() {
        this(null);
    }

    public LocalizedStringDeserializer(Class<LocalizedString> t) {
        super(t);
    }

    @Override
    public LocalizedString deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final Map<Locale, String> localized = new LinkedHashMap<>();

        JsonNode node = p.getCodec().readTree(p);
        final Iterator<Map.Entry<String, JsonNode>> it = node.fields();
        while (it.hasNext()) {
            final Map.Entry<String, JsonNode> entry = it.next();

            localized.put(new Locale(entry.getKey()), entry.getValue().textValue());
        }

        return new LocalizedString(localized);
    }
}
