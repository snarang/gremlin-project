package com.gremlin.models;

public enum Language {
    ENGLISH("en"),
    RUSSIAN("ru");

    private final String label;

    Language(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
