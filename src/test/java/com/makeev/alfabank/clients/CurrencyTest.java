package com.makeev.alfabank.clients;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.makeev.alfabank.clients.dto.Rate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "config.ratesUrl=http://localhost:8082")
@WireMockTest(httpPort = 8082)
class CurrencyTest {

    @Autowired
    Currency currency;

    @Test
    void getEx() throws IOException {
        stubFor(get(urlEqualTo("/latest.json?app_id=test&base=usd"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", String.valueOf(MediaType.APPLICATION_JSON))
                        .withBody(StreamUtils
                                .copyToString(getClass()
                                        .getClassLoader()
                                        .getResourceAsStream("currency.json"), Charset.defaultCharset()))));

        Rate rate = currency.getEx("test", "usd");
        Double except = 57.25;
        Assert.assertEquals(except,rate.getRates().get("RUB"));
    }

    @Test
    void getTime() {
    }

}