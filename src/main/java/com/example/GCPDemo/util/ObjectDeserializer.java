package com.example.GCPDemo.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class ObjectDeserializer {

    private static ObjectMapper objectMapper;

    static {

        objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    public Object deserializeObject(String jsonString, Class clazz) {

        try {

            return objectMapper.readValue(jsonString, clazz);

        } catch (IOException e) {

            log.error("Failed to deserialize the given json string {} {}", jsonString, e);

            return null;
        }
    }
}
