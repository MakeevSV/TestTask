package com.makeev.alfabank;

import com.makeev.alfabank.service.Service;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {
    @Autowired
    private Controller controller;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    Service service;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void returnPage() throws Exception {
        Mockito.when(service.course("RUB")).thenReturn(ResponseEntity.ok("OK"));
        Mockito.when(service.course("")).thenReturn(ResponseEntity.badRequest().body("Bad Request"));

        this.mockMvc.perform(get("/api/v1/course?name=rub")).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/v1/course")).andExpect(status().isBadRequest());
    }

}