package org.test.sample;

import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestDataProviderTest {

    @InjectMocks
    public RestDataProvider restDataProvider;

    @Mock
    public RestDataProvider.HttpClientComponentFactory httpClientComponentFactory;

    @Mock
    public UriProviderImpl uriProvider;

    @Mock
    public HttpClient client;

    @Test
    public void testDataProvider() throws IOException {
        when(httpClientComponentFactory.getHttpClient()).thenReturn(client);
        HttpResponse response = new BasicHttpResponse(new BasicStatusLine(
                new ProtocolVersion("http", 1, 2), 201, "the reason"));

        BasicHttpEntity httpEntity = new BasicHttpEntity();
        InputStream is = new ByteArrayInputStream("pillow".getBytes());
        httpEntity.setContent(is);
        response.setEntity(httpEntity);

        when(uriProvider.getUrl()).thenReturn("");

        when(httpClientComponentFactory.getStringBuilder()).thenReturn(new StringBuilder());

        when(httpClientComponentFactory.getBufferedReader(is)).thenReturn(
                new BufferedReader(new InputStreamReader(is)));

        when(client.execute(any(HttpUriRequest.class))).thenReturn(response);

//        doReturn(response).when(client).execute(any(HttpUriRequest.class));

        System.out.println(restDataProvider.getData());
    }

}
