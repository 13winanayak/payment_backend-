package com.paymetrust.backend.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Custom JPA converter for JsonNode to handle JSON data in database columns.
 */
@Converter(autoApply = true)
public class JsonNodeConverter implements AttributeConverter<JsonNode, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JsonNode to JSON string", e);
        }
    }

    @Override
    public JsonNode convertToEntityAttribute(String json) {
        if (!StringUtils.hasText(json)) {
            return null;
        }
        try {
            return objectMapper.readTree(json);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON string to JsonNode", e);
        }
    }
}