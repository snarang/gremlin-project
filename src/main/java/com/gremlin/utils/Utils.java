package com.gremlin.utils;

import java.util.Random;

public class Utils {
    public String generateRandomKey() {
        return "" + new Random().nextInt((99999 - 1) + 1) + 1;
    }
}
