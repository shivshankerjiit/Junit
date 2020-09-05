package com.example.demo.service;

import com.example.demo.beans.Item;
import com.example.demo.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item retriveHardCodedItem() {
        return new Item("youghurt",1,10.00,100);
    }

    @Override
    public List<Item> retriveAllItem() {
        List<Item> items = itemRepository.findAll();
        List<Item> itemWithVales = items.stream()
                .map(item -> {
                    double value = item.getQuantity() * item.getPrice();
                    item.setValue(value);
                    return item;
                })
                .collect(Collectors.toList());
        return itemWithVales;
    }
}
