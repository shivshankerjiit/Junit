package com.example.demo.controller;

import com.example.demo.beans.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello-World";
    }
    @GetMapping("/dummy-item")
    public Item getDummyItem(){
        Item i = new Item("youghurt",1,10.00,100);
        return new Item("youghurt",1,10.00,100);
    }
}
