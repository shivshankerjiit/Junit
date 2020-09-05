package com.example.demo.controller;

import com.example.demo.beans.Item;
import com.example.demo.service.ItemBusinessService;
import com.example.demo.service.ItemBusinessServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemBusinessService itemBusinessService;

    @Test
    public void getItemHardCodedTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-hardcode")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result =
                mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{name:youghurt,id:1,price:10.0,quantity:100}"))
                .andReturn();

        String txt = "LIAS LI LI bbbLI";

        // Demonstrating beginning of word boundary
        String regex1 = "\\bLI\\b"; // Matched at two places
        Pattern pattern1 = Pattern.compile(regex1, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(txt);
        /*while (matcher1.find())
        {
            System.out.println("Start index: " + matcher1.start());
            System.out.println("End index: " + matcher1.end());
        }*/
        System.out.println("b2-> " + matcher1.find());
    }

    @Test
    public void getItemBusinessHardCodedTest() throws Exception {
        given(itemBusinessService.retriveHardCodedItem()).willReturn(new Item("youghurt",1,10.00,100));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-business-hardcode")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{name:youghurt,id:1,price:10.0,quantity:100}"))
                .andReturn();
    }

    @Test
    public void getAllItemsTest() throws Exception{
        given(itemBusinessService.retriveAllItem()).willReturn(Arrays.asList(
                new Item("youghurt",1,10.00,100),
                new Item("fries",2,20.00,100)
        ));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{name:youghurt,id:1,price:10.00,quantity:100},{}]"))
                .andReturn();

    }
}