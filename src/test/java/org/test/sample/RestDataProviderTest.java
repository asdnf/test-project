package org.test.sample;

import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//import static org.junit.Assert.assertNotEquals;
//import java.lang.StringBuilder;

@RunWith(MockitoJUnitRunner.class)
public class RestDataProviderTest {

    InputStream is;

    @InjectMocks
    public RestDataProvider restDataProvider;

    @Before
    public void init() {
        System.out.println("init start");
        httpClientComponentFactory = mock(RestDataProvider.HttpClientComponentFactory.class);
        client = mock(HttpClient.class);
        request = mock(HttpGet.class);
        rd = mock(BufferedReader.class);
        response = mock(HttpResponse.class);
        sb = mock(StringBuilder.class);
        System.out.println("init end");

    }

    @Mock
    RestDataProvider.HttpClientComponentFactory httpClientComponentFactory;

    @Mock
    public UrlProvider urlProvider;

    @Mock
    public HttpClient client;

    @Mock
    public HttpGet request;

    @Mock
    public BufferedReader rd;

    @Mock
    HttpResponse response;

    @Mock
    public StringBuilder sb;


    @Test(expected = NullPointerException.class)
    public void testDataProvider() throws IOException {
        when(httpClientComponentFactory.getHttpClient()).thenReturn(client);
        when(httpClientComponentFactory.getHttpGetRequest(urlProvider.getUrl())).thenReturn(request);
        HttpResponse response = new BasicHttpResponse(new BasicStatusLine(
                new ProtocolVersion("http", 1, 2), 201, "the reason"));
        when(httpClientComponentFactory.getBufferedReader(is)).thenReturn(rd);
        when(httpClientComponentFactory.getStringBuilder()).thenReturn(sb);
    }
}
