package com.makeev.alfabank.clients;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.makeev.alfabank.clients.dto.GifObj;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(properties = "config.gifUrl=http://localhost:8082")
@WireMockTest(httpPort = 8082)
class GifTest {
    @Autowired
    Gif gif;


    @Test
    void getGif() throws IOException {
        stubFor(get(urlEqualTo("/random?api_key=test&tag=tag"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", String.valueOf(MediaType.APPLICATION_JSON))
                        .withBody(StreamUtils
                                .copyToString(getClass()
                                                .getClassLoader()
                                                .getResourceAsStream("gif.json"), Charset.defaultCharset()))));

       GifObj gifObj = gif.getGif("test", "tag");
        Assert.assertEquals("https://giphy.com/result", gifObj.toString());



    }
}