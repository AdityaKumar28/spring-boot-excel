package com.springbootexcel.poc.configuration;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.springbootexcel.poc.model.NetflixTitlesEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Field;

@Component
public class NetflixTitlesEntitySerializer extends StdSerializer<NetflixTitlesEntity> {

    @Value("${myapp.features.ignore-type-field}")
    private boolean ignoreTypeField;

    public NetflixTitlesEntitySerializer() {
        this(null);
    }

    public NetflixTitlesEntitySerializer(Class<NetflixTitlesEntity> t) {
        super(t);
    }

    @Override
    public void serialize(NetflixTitlesEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        for (Field field : NetflixTitlesEntity.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object fieldValue = field.get(value);
                if (!(ignoreTypeField && "type".equals(field.getName()))) {
                    gen.writeObjectField(field.getName(), fieldValue);
                }
            } catch (IllegalAccessException e) {
                // Handle the exception as appropriate for your application
            }
        }

        gen.writeEndObject();
    }
}

