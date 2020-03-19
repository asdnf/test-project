package org.test.sample;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RestDataProvider {

    private UrlProvider urlProvider;
    private HttpClientComponentFactory httpClientComponentFactory;

    public RestDataProvider(UrlProvider urlProvider,
                            HttpClientComponentFactory httpClientComponentFactory) throws IOException {
        this.urlProvider = urlProvider;
        this.httpClientComponentFactory = httpClientComponentFactory;
    }

    public String getData() throws IOException {
        HttpClient client = httpClientComponentFactory.getHttpClient();
        HttpGet request = httpClientComponentFactory.getHttpGetRequest(urlProvider.getUrl());
        HttpResponse response = client.execute(request);
        BufferedReader rd = httpClientComponentFactory.getBufferedReader(response.getEntity().getContent());
        StringBuilder sb = httpClientComponentFactory.getStringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static class HttpClientComponentFactory {
        public HttpClient getHttpClient() {
            return HttpClientBuilder.create().build();
        }

        public HttpGet getHttpGetRequest(String url) {
            return new HttpGet(url);
        }

        public BufferedReader getBufferedReader(InputStream is) {
            return new BufferedReader(new InputStreamReader(is));
        }

        public StringBuilder getStringBuilder() {
            return new StringBuilder();
        }
    }
}
