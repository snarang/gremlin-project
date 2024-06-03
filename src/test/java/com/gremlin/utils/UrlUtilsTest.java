package com.gremlin.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.Optional;

import com.gremlin.models.Language;
import com.gremlin.models.Method;
import com.gremlin.models.ResponseType;

public class UrlUtilsTest {
    @Test
    public void testUrlCreation() {
        String key = new Utils().generateRandomKey();
        String actual = new UrlUtils().generateUrl(Language.ENGLISH, Method.GET_QUOTE, ResponseType.xml,
                key);
        String expected = String.format("https://api.forismatic.com/api/1.0/?method=getQuote&format=xml&key=%s&lang=en",
                key);
        assertEquals(expected, actual);
    }
}
