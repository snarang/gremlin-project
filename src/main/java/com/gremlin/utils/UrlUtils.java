package com.gremlin.utils;

import com.gremlin.models.*;

public class UrlUtils {
    private final static String BASE_URL = "https://api.forismatic.com/api/1.0/";

    public String generateUrl(Language language, Method method, ResponseType format, String key) {
        if (key == null || key.isEmpty())
            key = new Utils().generateRandomKey();
        return BASE_URL + "?" + generateQueryParams(language, method, format, key.toString());
    }

    private String generateQueryParams(Language language, Method method, ResponseType format, String key) {
        return "method=" + method.label() + "&format=" + format.label() + "&key=" + key + "&lang=" + language.label();
    }
}
