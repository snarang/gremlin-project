package com.gremlin.parsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.charset.StandardCharsets;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import java.util.Optional;

import org.junit.Test;
import org.apache.commons.io.IOUtils;

import com.gremlin.models.Quote;

public class XmlParserTest {
    Path resourceDirectory = Paths.get("src", "test", "resources");

    @Test
    public void testParsing1() throws IOException {
        Quote quote = new XmlParser(getResourceAsString("/response_0.xml")).parse();

        assertNotNull(quote);
        assertEquals("If you spend your whole life waiting for the storm, you'll never enjoy the sunshine.",
                quote.getQuoteText());
        assertEquals("Morris West", quote.getQuoteAuthor().get());
        assertEquals(Optional.of("http://forismatic.com/ru/024ea407a2/"), quote.getQuoteLink());
    }

    private String getResourceAsString(String resourcePath) throws IOException {
        return IOUtils.toString(getClass().getResourceAsStream(resourcePath), StandardCharsets.UTF_8);
    }

    @Test
    public void testParsing2() throws IOException {
        Quote quote = new XmlParser(getResourceAsString("/response_45d5c2e2b1.xml")).parse();

        assertNotNull(quote);
        assertEquals("To bring anything into your life, imagine that it's already there.", quote.getQuoteText());
        assertEquals(Optional.empty(), quote.getQuoteAuthor());
        assertEquals(Optional.of("http://forismatic.com/en/45d5c2e2b1/"), quote.getQuoteLink());
    }

    @Test
    public void testParsing3() throws IOException {
        Quote quote = new XmlParser(getResourceAsString("/response_77b67d9ed1.xml")).parse();

        assertNotNull(quote);
        assertEquals(
                "It is in your moments of decision that your destiny is shaped.",
                quote.getQuoteText());
        assertEquals("Tony Robbins", quote.getQuoteAuthor().get());
        assertEquals(Optional.empty(), quote.getQuoteLink());
    }

}
