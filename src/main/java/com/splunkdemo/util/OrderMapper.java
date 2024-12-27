package com.splunkdemo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderMapper {

    private static final Logger logger = LogManager.getLogger(OrderMapper.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String mapToJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Error converting object to JSON string: {}", e.getMessage(), e);
        }
        return null;
    }
}
