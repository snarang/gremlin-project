package com.gremlin.models;

public enum Method {
    GET_QUOTE("getQuote");

    private final String label;

    Method(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
