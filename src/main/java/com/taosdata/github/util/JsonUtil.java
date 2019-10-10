package com.taosdata.github.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json 相关格式方法
 */
public class JsonUtil {
    

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        objectMapper.setDateFormat(DATEFORMAT);//设置默认日期格式
    }

    /**
     * 将 json 字符串解析为指定对象
     * @param json
     * @param cls
     * @return
     * @throws Exception
     */
    public static Object json2Bean(String json, Class<?> cls) throws Exception{
            return objectMapper.readValue(json, cls);
    }

    /**
     * 将指定对象转换为 json 字符串
     * @param object
     * @return
     * @throws IOException
     */
    public static String toJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }


}