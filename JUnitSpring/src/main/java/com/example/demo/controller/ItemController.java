package com.example.demo.controller;

import com.example.demo.beans.Item;
import com.example.demo.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService itemBusinessService;

    @GetMapping("/item-hardcode")
    public Item getItemHardCoded(){
        return new Item("youghurt",1,10.00,100);
    }

    @GetMapping("/item-business-hardcode")
    public Item getItemBusinessHardCoded(){
        return itemBusinessService.retriveHardCodedItem();
    }

    @GetMapping("/item-all")
    public List<Item> getAllItems(){
        return itemBusinessService.retriveAllItem();
    }
}
