package com.gremlin;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.gremlin.models.Language;
import com.gremlin.models.Method;
import com.gremlin.models.Quote;
import com.gremlin.models.ResponseType;
import com.gremlin.processors.ForsmaticApiHandler;

public class QuoteProcessorApplication {
    public static void main(String[] args) throws IOException, ParseException {
        // parse arguments

        Quote quote = new ForsmaticApiHandler(Language.ENGLISH, ResponseType.xml, Method.GET_QUOTE)
                .getProcessedResult();
        System.out.printf("Text = \"%s\"", quote.getQuoteText());
        System.out.printf("\nAuthor = %s%n", quote.getQuoteAuthor().orElse("Unknown author"));

        quote = new ForsmaticApiHandler(Language.ENGLISH, ResponseType.xml, Method.GET_QUOTE)
                .getProcessedResult();
        System.out.printf("Text = \"%s\"", quote.getQuoteText());
        System.out.printf("\nAuthor = %s%n", quote.getQuoteAuthor().orElse("Unknown author"));

    }
}
