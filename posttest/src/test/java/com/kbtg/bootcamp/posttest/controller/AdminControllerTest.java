package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.mapper.LotteryMapper;
import com.kbtg.bootcamp.posttest.request.LotteryRequest;
import com.kbtg.bootcamp.posttest.response.LotteryResponse;
import com.kbtg.bootcamp.posttest.service.LotteryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LotteryService lotteryService;

    @Test
    public void testCreateLottery() throws Exception {
        String requestBody = "{\"ticket\": \"123456\", \"price\": 100, \"amount\": 10}";
        LotteryRequest.create request = new LotteryRequest.create("123456", 100, 10);
        LotteryResponse.create response = new LotteryResponse.create("123456");

        Mockito.when(lotteryService.create(Mockito.any())).thenReturn(ResponseEntity.ok(response));

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/lotteries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.ticket").value("123456"));

        Mockito.verify(lotteryService, Mockito.times(1)).create(Mockito.any());
    }
}

