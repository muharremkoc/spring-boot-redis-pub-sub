package com.pubsub.springbootredispubsub.publisher;

import com.pubsub.springbootredispubsub.model.Item;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service

public class ItemPublisherServiceImpl implements ItemPublisherService{

    Logger log =  LoggerFactory.getLogger(ItemPublisherServiceImpl.class);

    private final RedisTemplate<String,Object> redisTemplate;

    private final ChannelTopic channelTopic;

    public ItemPublisherServiceImpl(RedisTemplate<String, Object> redisTemplate, ChannelTopic channelTopic) {
        this.redisTemplate = redisTemplate;
        this.channelTopic = channelTopic;
    }

    @Override
    public Long publish(Item item) {
        log.info(String.format("Sending Message: %s",item.toString()));
        return redisTemplate.convertAndSend(channelTopic.getTopic(), item);
    }
}
