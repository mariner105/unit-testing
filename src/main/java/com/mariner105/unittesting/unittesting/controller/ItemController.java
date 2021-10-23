package com.mariner105.unittesting.unittesting.controller;

import com.mariner105.unittesting.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem() {

        return new Item(1, "Ball", 10, 100);
    }


}
