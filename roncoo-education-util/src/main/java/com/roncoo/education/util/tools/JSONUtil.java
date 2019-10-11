package com.roncoo.education.util.tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-04-26-15:25
 * @email:wk20041208@126.com
 */
public class JSONUtil {

    public JSONUtil() {
    }
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJSONString(Object obj){
        try {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static <T> List<T> parseArray(String jsonString,Class<T> elementClasses){
       mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, elementClasses);
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> T parseObject(String jsonString, Class<T> elementClasses) {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            return mapper.readValue(jsonString, elementClasses);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
