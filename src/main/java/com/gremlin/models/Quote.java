package com.gremlin.models;

import java.util.Optional;

public class Quote {
    private final String quoteText;
    private final Optional<String> quoteAuthor;
    private final Optional<String> quoteLink;
    private final Optional<String> senderName;
    private final Optional<String> senderLink;

    public Quote(String quoteText, Optional<String> quoteAuthor, Optional<String> quoteLink,
            Optional<String> senderName, Optional<String> senderLink) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
        this.quoteLink = quoteLink;
        this.senderName = senderName;
        this.senderLink = senderLink;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public Optional<String> getQuoteAuthor() {
        return quoteAuthor;
    }

    public Optional<String> getQuoteLink() {
        return quoteLink;
    }

    public Optional<String> getSenderName() {
        return senderName;
    }

    public Optional<String> getSenderLink() {
        return senderLink;
    }
}
