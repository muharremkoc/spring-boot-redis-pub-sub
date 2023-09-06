package com.pubsub.springbootredispubsub.publisher;

import com.pubsub.springbootredispubsub.model.Item;

public interface ItemPublisherService {

    Long publish(Item item);
}
