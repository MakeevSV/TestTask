package com.makeev.alfabank.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.makeev.alfabank.Utils;
import com.makeev.alfabank.exp.NotValidInputException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ServiceTest {

    @MockBean
    private Clients clients;
    @MockBean
    private Utils utils;
    @Autowired
    Service service;

    @Test
    void courseUp() throws JsonProcessingException, NotValidInputException {
        Mockito.when(utils.checkInputRate("RUB")).thenReturn("RUB");
        Mockito.when(clients.getRate("RUB")).thenReturn(1.0);
        Mockito.when(clients.getRate("RUB",service.yesterdayDate())).thenReturn(0.5);
        Mockito.when(clients.getGif("rich")).thenReturn("richGif");
        Mockito.when(clients.getGif("broke")).thenReturn("brokeGif");

        Assert.assertEquals("richGif",service.course("RUB").getBody());
    }

    @Test
    void courseDown() throws JsonProcessingException, NotValidInputException {
        Mockito.when(utils.checkInputRate("RUB")).thenReturn("RUB");
        Mockito.when(clients.getRate("RUB")).thenReturn(0.5);
        Mockito.when(clients.getRate("RUB",service.yesterdayDate())).thenReturn(1.1);
        Mockito.when(clients.getGif("rich")).thenReturn("richGif");
        Mockito.when(clients.getGif("broke")).thenReturn("brokeGif");

        Assert.assertEquals("brokeGif",service.course("RUB").getBody());
    }


}