package org.test.sample;

public class UriProviderImpl implements UrlProvider {

    private String url;

    public UriProviderImpl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
