package com.tech.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 22:39
 **/
public class StringUtils {

    public static String getUrlPath(String requestParamString) {

        String[] requestPath = requestParamString.split("\\?");
        return requestPath[0];

    }


    public static Map<String, String> getParameterMap(String requestParamString) {

        String[] requestPath = requestParamString.split("\\?");
        String[] paramString = requestPath[1].split("&&");

        Map<String, String> stringMap = new HashMap<>(10);

        for (int i = 0; i < paramString.length; i++) {
            String param = paramString[i];
            String[] paramMapValue = param.split("=");
            stringMap.put(paramMapValue[0], paramMapValue[1]);
        }

        return stringMap;


    }

}
