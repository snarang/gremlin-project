package com.gremlin.parsers;

import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.gremlin.models.Quote;

public class JsonParser {

    private final static String JSON_QUOTE_TEXT_PATH = "quoteText";
    private final static String JSON_QUOTE_TEXT_AUTHOR_PATH = "quoteAuthor";
    private final static String JSON_QUOTE_LINK_PATH = "quoteLink";
    private final static String JSON_SENDER_NAME_PATH = "senderName";
    private final static String JSON_SENDER_LINK_PATH = "senderLink";

    String quoteAsJson;
    JSONParser parser = new JSONParser();
    JSONObject jsonObject;

    public JsonParser(String quoteAsJson) {
        this.quoteAsJson = quoteAsJson;

        try {
            this.jsonObject = (JSONObject) parser.parse(quoteAsJson);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Quote parse() throws ParseException {
        Quote quote = null;

        quote = new Quote(parseQuoteText(), parseQuoteAuthor(), parseQuoteLink(), parseSenderName(),
                parseSenderLink());

        return quote;
    }

    private String parseQuoteText() {
        return (String) jsonObject.get(JSON_QUOTE_TEXT_PATH);
    }

    private Optional<String> parseQuoteAuthor() {
        return Optional.of((String) jsonObject.get(JSON_QUOTE_TEXT_AUTHOR_PATH));
    }

    private Optional<String> parseQuoteLink() {
        return Optional.of((String) jsonObject.get(JSON_QUOTE_LINK_PATH));
    }

    private Optional<String> parseSenderName() {
        return Optional.of((String) jsonObject.get(JSON_SENDER_NAME_PATH));
    }

    private Optional<String> parseSenderLink() {
        return Optional.of((String) jsonObject.get(JSON_SENDER_LINK_PATH));
    }
}
