package config;

import com.test.common.sensitive.annotation.Desensitize;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import enums.DesensitizeType;
import util.DesensitizedUtils;

import java.io.IOException;
import java.util.Objects;

public class DesensitizeSerializer extends JsonSerializer<String> implements ContextualSerializer {
    private DesensitizeType type;

    private Integer startIndex;

    private Integer endIndex;

    // Constructor
    public DesensitizeSerializer() {

    }

    // Constructor
    public DesensitizeSerializer(DesensitizeType type, Integer startIndex, Integer endIndex) {
        this.type = type;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        switch (type) {
            case CHINESE_NAME:
                jsonGenerator.writeString(DesensitizedUtils.chineseName(value));
                break;
            default:
                break;
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty beanProperty ) throws JsonMappingException {
        if (beanProperty != null) {
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
                Desensitize desensitize = beanProperty.getAnnotation(Desensitize.class);
                if (desensitize == null) {
                    desensitize = beanProperty.getContextAnnotation(Desensitize.class);
                }
                if (desensitize != null) {
                    return new DesensitizeSerializer(desensitize.type(), desensitize.startIndex(), desensitize.endIndex());
                }
            }
            return provider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return provider.findNullValueSerializer(null);
    }
}
