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
