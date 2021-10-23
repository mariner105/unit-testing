package com.mariner105.unittesting.unittesting.business;

import com.mariner105.unittesting.unittesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retreiveHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
