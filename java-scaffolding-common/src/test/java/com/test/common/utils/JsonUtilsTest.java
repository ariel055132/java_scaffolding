package com.test.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonUtilsTest {

    @Test
    @DisplayName("Convert Object to JSON string")
    void convertObjectToJsonString() {
        // Given
        CarClass carClass = new CarClass("yellow", "renault");
        // When
        String actualJsonString = JsonUtils.toJson(carClass);
        System.out.println(actualJsonString);
        // Then
        assertNotNull(actualJsonString);
        assertTrue(actualJsonString.contains("\"color\":\"yellow\",\"type\":\"renault\""));
    }

    @Test
    @DisplayName("Convert Json String to Object")
    void convertJsonStringToObject() {
        // Given
        String jsonString = "{\"color\":\"yellow\",\"type\":\"renault\"}";
        // When
        CarClass actualCarClass = JsonUtils.toObject(jsonString, CarClass.class);
        System.out.println(actualCarClass.toString());
        // Then
        assertNotNull(actualCarClass);
        assertEquals(actualCarClass.getColor(), "yellow");
        assertEquals(actualCarClass.getType(), "renault");
    }

    @Test
    @DisplayName("Convert List<Car> to Json String")
    void convertListCarToJson() {
        // Given
        CarClass carClass1 = new CarClass("red", "audi");
        CarClass carClass2 = new CarClass("blue", "bmw");
        List<CarClass> carClassList = new ArrayList<>();
        carClassList.add(carClass1);
        carClassList.add(carClass2);
        // When
        String actualJsonString = JsonUtils.listToJson(Collections.singletonList(carClassList));
        // Then
        System.out.println(actualJsonString);
    }

    @Test
    @DisplayName("Convert Json String to List<Car>")
    void convertJsonToListCar() {
       // Given
        String jsonString = "[{\"color\":\"red\",\"type\":\"audi\"},{\"color\":\"blue\",\"type\":\"bmw\"}]";
        // When
        List<Object> actualCarClassList = JsonUtils.jsonToList(jsonString);
        // Then
        assertNotNull(actualCarClassList);
        assertEquals(actualCarClassList.size(), 2);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class CarClass {
        private String color;

        private String type;
    }
}
