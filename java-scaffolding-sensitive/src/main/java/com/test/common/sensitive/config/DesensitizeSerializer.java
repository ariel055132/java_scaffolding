package com.test.common.sensitive.config;

import com.test.common.sensitive.annotation.Desensitize;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.test.common.sensitive.enums.DesensitizeType;
import com.test.common.sensitive.util.DesensitizedUtils;
import com.test.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class DesensitizeSerializer extends JsonSerializer<String> implements ContextualSerializer {
    private DesensitizeType type;

    private Integer startIndex;

    private Integer endIndex;

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String newStr;
        switch (type) {
            case CHINESE_NAME:
                newStr = DesensitizedUtils.chineseName(value);
                break;
            case ENGLISH_NAME:
                newStr = DesensitizedUtils.englishName(value);
                break;
            case BIRTH_DATE:
                newStr = DesensitizedUtils.birthDate(value);
                break;
            case ID_NUMBER:
                newStr = DesensitizedUtils.idNumber(value);
                break;
            case PHONE_NUMBER:
                newStr = DesensitizedUtils.phoneNumber(value);
                break;
            case CELL_PHONE_NUMBER:
                newStr = DesensitizedUtils.cellPhoneNumber(value);
                break;
            case CHINESE_ADDRESS:
                newStr = DesensitizedUtils.chineseAddress(value);
                break;
            case ENGLISH_ADDRESS:
                newStr = DesensitizedUtils.englishAddress(value);
                break;
            case EMAIL:
                newStr = DesensitizedUtils.email(value);
                break;
            case CUSTOM_RULE:
                if (StringUtils.isBlank(value)) {
                    newStr = value;
                } else {
                    newStr = StringUtils.substring("*", startIndex, endIndex);
                }
                break;
            default:
                newStr = value;
        }
        jsonGenerator.writeString(newStr);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty beanProperty ) throws JsonMappingException {
        if (beanProperty != null) {
            // Determine if the data type of the current field is string or not.
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
                // Retrieve the defined annotation (defined in DesensitizeType)
                // It first checks for the annotation directly on the field, and if not found, it checks for the annotation in the context of the field.
                Desensitize desensitize = beanProperty.getAnnotation(Desensitize.class);
                // If the Desensitize annotation is present, a new instance of DesensitizeSerializer is created with the parameters specified in the annotation (i.e., type, startIndex, and endIndex)
                if (desensitize == null) {
                    desensitize = beanProperty.getContextAnnotation(Desensitize.class);
                }
                // If the field is not of type String or the Desensitize annotation is not present, the method delegates the creation of the serializer to the SerializerProvider by calling findValueSerializer with the type of the property
                if (desensitize != null) {
                    return new DesensitizeSerializer(desensitize.type(), desensitize.startIndex(), desensitize.endIndex());
                }
            }
            // If the field is not of type String / desensitize annotation is not present, the methods delegates the creation of the serializer to the SerializerProvider by calling the findValueSerializer with the type of the property.
            return provider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        // If bean property is null, returns a serializer for null values. (~null checking)
        return provider.findNullValueSerializer(null);
    }
}
