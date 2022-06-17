package com.makeev.alfabank.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GifObj {

    public GifObj() {
    }
    @JsonProperty("data")
    private Properties properties;

    @Override
    public String toString() {
        return properties.toString();
    }

class Properties{

    public Properties() {
    }
    @JsonProperty("embed_url")
    private String embed_url;

    @Override
    public String toString() {
        return embed_url;
    }
}
}
