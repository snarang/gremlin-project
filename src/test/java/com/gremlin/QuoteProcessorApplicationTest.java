package com.gremlin;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.gremlin.models.Language;
import com.gremlin.models.Method;
import com.gremlin.models.Quote;
import com.gremlin.models.ResponseType;
import com.gremlin.processors.ForsmaticApiHandler;

public class QuoteProcessorApplicationTest {
    @Test
    public void testApi() throws IOException, ParseException {
        Quote quote = new ForsmaticApiHandler(Language.RUSSIAN, ResponseType.xml, Method.GET_QUOTE)
                .getProcessedResult();

        assertNotNull(quote);
        assertNotNull(quote.getQuoteText());
        assertNotNull(quote.getQuoteAuthor());
    }

    @Test
    public void testApi1() throws IOException, ParseException {
        Quote quote = new ForsmaticApiHandler(Language.ENGLISH, ResponseType.json, Method.GET_QUOTE)
                .getProcessedResult();

        assertNotNull(quote);
        assertNotNull(quote.getQuoteText());
        assertNotNull(quote.getQuoteAuthor());
    }
}
