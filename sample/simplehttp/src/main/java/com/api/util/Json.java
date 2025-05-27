package com.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class Json {

    private static ObjectMapper mapper = getMapper();

    private static ObjectMapper getMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static JsonNode parse(String jsonSrc) throws JsonProcessingException {
        return mapper.readTree(jsonSrc);
    }

    public static <A> A fromJson(JsonNode jsonNode, Class<A> aClass) throws JsonProcessingException {
        return mapper.treeToValue(jsonNode, aClass);
    }

    public static JsonNode toJson(Object obj) throws JsonProcessingException {
        return mapper.valueToTree(obj);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {

        return generateJson(node, false);
    }

    public static String stringifyPretty(JsonNode node) throws JsonProcessingException {

        return generateJson(node, true);
    }

    private static String generateJson(Object obj, boolean pretty) throws JsonProcessingException {
        ObjectWriter ow = mapper.writer();
        if (pretty) {
            ow = ow.with(SerializationFeature.INDENT_OUTPUT);
        }
        return ow.writeValueAsString(obj);
    }
}
