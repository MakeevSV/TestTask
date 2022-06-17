package com.makeev.alfabank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config")
public class Config {
    private String gifApiKey;
    private String gifUrl;
    private String ratesApiKey;
    private String ratesUrl;
    private String baseCurrency;

    public Config() {
    }

    public String getGifApiKey() {
        return gifApiKey;
    }

    public void setGifApiKey(String gifApiKey) {
        this.gifApiKey = gifApiKey;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public String getRatesApiKey() {
        return ratesApiKey;
    }

    public void setRatesApiKey(String ratesApiKey) {
        this.ratesApiKey = ratesApiKey;
    }

    public String getRatesUrl() {
        return ratesUrl;
    }

    public void setRatesUrl(String ratesUrl) {
        this.ratesUrl = ratesUrl;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }
}
