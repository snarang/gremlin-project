package com.gremlin.processors;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.gremlin.models.Language;
import com.gremlin.models.Method;
import com.gremlin.models.Quote;
import com.gremlin.models.ResponseType;

public class ForsmaticApiHandlerTest {
    @Test
    public void testProcessedResults() throws IOException, ParseException {
        Quote quote = new ForsmaticApiHandler(Language.ENGLISH, ResponseType.xml, Method.GET_QUOTE)
                .getProcessedResult();

        assertNotNull(quote);
        assertNotNull(quote.getQuoteText());
        assertNotNull(quote.getQuoteAuthor());
    }

    @Test
    public void testProcessedResults1() throws IOException, ParseException {
        Quote quote = new ForsmaticApiHandler(Language.RUSSIAN, ResponseType.xml, Method.GET_QUOTE)
                .getProcessedResult();

        assertNotNull(quote);
        assertNotNull(quote.getQuoteText());
        assertNotNull(quote.getQuoteAuthor());
    }

    @Test
    public void testProcessedResults2() throws IOException, ParseException {
        Quote quote = new ForsmaticApiHandler(Language.RUSSIAN, ResponseType.json, Method.GET_QUOTE)
                .getProcessedResult();

        assertNotNull(quote);
        assertNotNull(quote.getQuoteText());
        assertNotNull(quote.getQuoteAuthor());
    }
}
