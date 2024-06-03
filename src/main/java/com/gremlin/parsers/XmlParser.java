package com.gremlin.parsers;

import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.Optional;

import com.gremlin.models.Quote;

public class XmlParser {
    private final static String XML_QUOTE_TEXT_PATH = "/forismatic/quote/quoteText";
    private final static String XML_QUOTE_TEXT_AUTHOR_PATH = "/forismatic/quote/quoteAuthor";
    private final static String XML_QUOTE_LINK_PATH = "/forismatic/quote/quoteLink";

    private String quoteAsXml;
    private XPath xPath;

    public XmlParser(String quoteAsXml) {
        this.quoteAsXml = quoteAsXml;
        this.xPath = XPathFactory.newInstance().newXPath();
    }

    public Quote parse() {
        Quote quote = null;

        try {
            quote = new Quote(parseQuoteText(), parseQuoteAuthor(), parseQuoteLink(), parseSenderName(),
                    parseSenderLink());
        } catch (XPathException e) {
            System.out.println(String.format("Failed parse quote because of: %s", e.getMessage()));
            e.printStackTrace();
        }

        return quote;
    }

    private String parseQuoteText() throws XPathExpressionException {
        return xPath.evaluate(XML_QUOTE_TEXT_PATH, new InputSource(new StringReader(quoteAsXml)));
    }

    private Optional<String> parseQuoteAuthor() throws XPathExpressionException {
        String quoteAuthor = xPath.evaluate(XML_QUOTE_TEXT_AUTHOR_PATH, new InputSource(new StringReader(quoteAsXml)));
        Optional<String> outp;
        if (quoteAuthor != null && !quoteAuthor.isEmpty())
            outp = Optional.of(quoteAuthor);
        else
            outp = Optional.empty();
        return outp;
        // return quoteAuthor != null && !quoteAuthor.isEmpty() ?
        // Optional.of(quoteAuthor) : Optional.empty();
    }

    private Optional<String> parseQuoteLink() throws XPathExpressionException {
        String quoteLink = xPath.evaluate(XML_QUOTE_LINK_PATH, new InputSource(new StringReader(quoteAsXml)));
        Optional<String> outp;
        if (quoteLink != null && !quoteLink.isEmpty())
            outp = Optional.of(quoteLink);
        else
            outp = Optional.empty();
        return outp;
        // return quoteLink != null && !quoteLink.isEmpty() ? Optional.of(quoteLink) :
        // Optional.empty();
    }

    private Optional<String> parseSenderName() throws XPathExpressionException {
        String senderName = xPath.evaluate(XML_QUOTE_LINK_PATH, new InputSource(new StringReader(quoteAsXml)));
        Optional<String> outp;
        if (senderName != null && !senderName.isEmpty())
            outp = Optional.of(senderName);
        else
            outp = Optional.empty();
        return outp;
        // return senderName != null && !senderName.isEmpty() ? Optional.of(senderName)
        // : Optional.empty();

    }

    private Optional<String> parseSenderLink() throws XPathExpressionException {
        String senderLink = xPath.evaluate(XML_QUOTE_LINK_PATH, new InputSource(new StringReader(quoteAsXml)));
        Optional<String> outp;
        if (senderLink != null && !senderLink.isEmpty())
            outp = Optional.of(senderLink);
        else
            outp = Optional.empty();
        return outp;
        // somehow below is not working in my env
        // return senderLink != null && !senderLink.isEmpty() ? Optional.of(senderLink)
        // : Optional.empty();

    }
}
