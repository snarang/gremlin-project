package com.gremlin.models;

public enum ResponseType {
    xml("xml"),
    json("json"),
    html("html"),
    jsonp("jsonp"),
    text("text");

    private final String label;

    ResponseType(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
