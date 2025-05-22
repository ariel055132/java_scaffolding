package com.test.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Json 共用函式
 *
 * @author Adrian
 * @date 2025/02/17
 */

public class JsonUtils {
    /**
     * 建立 ObjectMapper 物件，並設定不要拋出未知屬性的例外
     * Create an ObjectMapper object and set it not to throw exceptions for unknown properties.
     */
    private final static ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    /**
     * 將物件轉換成 JSON 字串
     * Convert Object to JSON string. (Serialize)
     * 1. Determine if the object is null, if it is null, return null.
     * 2. Use the ObjectMapper.writeValueAsString method to convert the object to a JSON string.
     * 3. If an exception occurs, return an empty string.
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static String toJson(Object object) {
        if (object == null) {
            return null;
        }
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            LogUtils.info("JsonUtils.toJson success : {} ", jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 將 JSON 字串轉換成物件
     * Convert JSON string to Object. (Deserialize)
     * 1. Determine if the JSON string or objectClass is null, if one of them is null, return null.
     * 2. Use the ObjectMapper.readValue method to convert the JSON string to an object.
     * 3. If an exception occurs, return null.
     *
     * @param json
     * @param objectClass
     * @return
     * @param <T>
     */
    public static <T> T toObject(String json, Class<T> objectClass) {
        if (json == null || objectClass == null) {
            return null;
        }
        try {
            return objectMapper.readValue(json, objectClass);
        } catch (IOException e) {
            LogUtils.debug("JsonUtils.toObject error: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 將 Map 轉換成 Json 字串
     * Convert Map to Json String. (Serialize)
     * 1. Determine if the Map is null, if it is null, return null.
     * 2. Use the ObjectMapper.writeValueAsString method to convert the Map to a JSON string.
     * 3. If an exception occurs, return null.
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 將 Json 字串轉換成 Map
     * Convert Json String to Map. (Deserialize)
     * 1. Determine if the JSON string is null or blank, if it is null or blank, return null.
     * 2. Use the ObjectMapper.readValue method to convert the JSON string to a Map.
     * 3. If an exception occurs, return null.
     */
    public static Map<String, Object> jsonToMap(String jsonString) {
        if (jsonString == null || jsonString.isBlank()) {
            return null;
        }
        try {
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {};
            return objectMapper.readValue(jsonString, typeRef);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 將 List<Object> 轉換成 Json 字串
     * Convert List<Object> to Json String. (Serialize)
     * 1. Determine if the List is null or empty, if it is null or empty, return null.
     * 2. Use the ObjectMapper.writeValueAsString method to convert the List to a JSON string.
     * 3. If an exception occurs, return null.
     * @param list
     * @return
     * @throws JsonProcessingException
     */
    public static String listToJson(List<Object> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 將 Json 字串轉換成 List<Object> 物件
     */
    public static List<Object> jsonToList(String jsonString) {
        if (jsonString == null || jsonString.isBlank()) {
            return null;
        }
        try {
            TypeReference<List<Object>> typeRef = new TypeReference<List<Object>>() {};
            return objectMapper.readValue(jsonString, typeRef);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private JsonUtils() {
    }

}
