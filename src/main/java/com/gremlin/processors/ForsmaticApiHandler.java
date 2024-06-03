package com.gremlin.processors;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.json.simple.parser.ParseException;
import java.util.Optional;

import com.gremlin.models.Language;
import com.gremlin.models.Method;
import com.gremlin.models.ResponseType;
import com.gremlin.models.Quote;
import com.gremlin.parsers.JsonParser;
import com.gremlin.parsers.XmlParser;
import com.gremlin.utils.UrlUtils;

public class ForsmaticApiHandler {
    private Language language;
    private Method method;
    private ResponseType format;

    public ForsmaticApiHandler() {
        this.language = Language.ENGLISH;
        this.method = Method.GET_QUOTE;
        this.format = ResponseType.xml;
    }

    public ForsmaticApiHandler(Language language, ResponseType format, Method method) {
        this.language = language;
        this.method = method;
        this.format = format;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public void setFormat(ResponseType format) {
        this.format = format;
    }

    public ResponseType getFormat() {
        return format;
    }

    public Quote getProcessedResult() throws IOException, ParseException {
        if (format.label().equals("xml"))
            return new XmlParser(retrieveQuote()).parse();
        else if (format.label().equals("json"))
            return new JsonParser(retrieveQuote()).parse();
        else
            return new Quote("Unknown data", Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    private String retrieveQuote() throws IOException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(new UrlUtils().generateUrl(language, method, format, "")))
                .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
