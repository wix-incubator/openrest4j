package com.wix.restaurants.i18n;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;

public class LocalizedStringSerializer extends StdSerializer<LocalizedString> {

    public LocalizedStringSerializer() {
        this(null);
    }

    public LocalizedStringSerializer(Class<LocalizedString> t) {
        super(t);
    }

    @Override
    public void serialize(LocalizedString value, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        for (Map.Entry<Locale, String> entry : value.getLocalized().entrySet()) {
            gen.writeStringField(entry.getKey().toString(), entry.getValue());
        }
        gen.writeEndObject();
    }
}