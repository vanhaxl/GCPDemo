package com.example.GCPDemo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ObjectSerializer {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public String serializeObject(Object obj) {

        try {

            return objectMapper.writeValueAsString(obj);

        } catch (JsonProcessingException e) {

            log.error("Failed to serialize the given object", e);

            return null;
        }
    }

}
