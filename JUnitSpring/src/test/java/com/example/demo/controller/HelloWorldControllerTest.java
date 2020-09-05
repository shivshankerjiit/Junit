package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class) -> for JUnit4
// We don't want to launch complete application, but test single controller
@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    MockMvc mockMvc;
    //WebMvcTest given MockMvc

    @Test
    public void helloWorld_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"youghurt\",\"id\":1,\"price\":10.0,\"quantity\":100}"))
                .andReturn();
        //.andExpect(content().json(..) better than content().string(..) ,
        //      string() -> do exact match with space and whole response.
        //      json() -> 1) json match,
        //                2) match only those values that are present

    }

}