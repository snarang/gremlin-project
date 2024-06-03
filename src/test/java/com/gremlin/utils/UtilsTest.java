package com.gremlin.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void testRandomKey() {
        for (int i = 0; i < 10; i++) {
            String random = new Utils().generateRandomKey();
            assertTrue(random.length() >= 1 && random.length() <= 6);
        }
    }
}
