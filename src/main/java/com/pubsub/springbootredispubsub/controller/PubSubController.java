package com.pubsub.springbootredispubsub.controller;

import com.pubsub.springbootredispubsub.model.Item;
import com.pubsub.springbootredispubsub.publisher.ItemPublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubController {

    private final ItemPublisherService itemPublisherService;

    public PubSubController(ItemPublisherService itemPublisherService) {
        this.itemPublisherService = itemPublisherService;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody Item item) {
        itemPublisherService.publish(item);
        return "Success";
    }
}
