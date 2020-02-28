package com.example.GCPDemo.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ObjectDeserializer {

    public Logger LOG = LoggerFactory.getLogger(this.getClass());

    private static ObjectMapper objectMapper;

    static {

        objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    public Object deserializeObject(String jsonString, Class clazz) {

        try {

            return objectMapper.readValue(jsonString, clazz);

        } catch (IOException e) {

            LOG.error("Failed to deserialize the given json string {}", jsonString, e);

            return null;
        }
    }
}
