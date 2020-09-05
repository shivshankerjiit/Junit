package com.example.demo.service;

import com.example.demo.beans.Item;

import java.util.List;

public interface ItemBusinessService {

    public Item retriveHardCodedItem();

    public List<Item> retriveAllItem();
}
