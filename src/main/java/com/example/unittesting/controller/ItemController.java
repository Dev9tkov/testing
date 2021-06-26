package com.example.unittesting.controller;

import com.example.unittesting.business.ItemBuisnessService;
import com.example.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    private ItemBuisnessService itemBuisnessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100, 10);
    }

    @GetMapping("/item-from-buisness-service")
    public Item itemFromBuisnessService() {
        return itemBuisnessService.retreiveHardcodedItem();
    }
}
