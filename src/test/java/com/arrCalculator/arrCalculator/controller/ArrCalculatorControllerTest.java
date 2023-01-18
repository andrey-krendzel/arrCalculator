package com.arrCalculator.arrCalculator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest
    public class ArrCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public ArrCalculatorControllerTest() throws Exception {
    }

    @Test
    public void getShouldReturnMissingInt() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.
                        get("/calculate/5,1,0,4,10,6,-3,-2")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string("2"))
                .andReturn();

        System.out.println("Expected value: 2");
        System.out.println("Returned value: " + result.getResponse().getContentAsString());

        MvcResult result2 = mockMvc.perform(MockMvcRequestBuilders.
                        get("/calculate/1,5,3,2,0,1,-3,-6,-4")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string("4")).andReturn();

        System.out.println("Expected value: 4");
        System.out.println("Returned value: " + result2.getResponse().getContentAsString());


    }

    @Test
    public void postShouldReturnMissingInt() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/calculateAlternative")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[5,1,0,4,10,6,-3,-2]")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("2"))
                .andReturn();

        System.out.println("Expected value: 2");
        System.out.println("Returned value: " + result.getResponse().getContentAsString());


        MvcResult result2 = mockMvc.perform(MockMvcRequestBuilders.post("/calculateAlternative")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[1,5,3,2,0,1,-3,-6,-4]")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("4"))
                .andReturn();

        System.out.println("Expected value: 4");
        System.out.println("Returned value: " + result2.getResponse().getContentAsString());

    }
}