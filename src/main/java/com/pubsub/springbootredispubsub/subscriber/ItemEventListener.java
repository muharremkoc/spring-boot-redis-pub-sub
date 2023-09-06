package com.pubsub.springbootredispubsub.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubsub.springbootredispubsub.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemEventListener implements MessageListener {

    private final ObjectMapper objectMapper;

    private final RedisTemplate<String,Object> redisTemplate;

    public ItemEventListener(ObjectMapper objectMapper, RedisTemplate<String, Object> redisTemplate) {
        this.objectMapper = objectMapper;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info(String.format("new message received: %s", message.toString()));
        try {
            Item item = objectMapper.readValue(message.getBody(), Item.class);
            redisTemplate.opsForValue().set(item.getItemID(),item);
         log.info(String.format( "Item Subscribe operations is success: %s",item));
        } catch (Exception e) {
          log.error(e.getMessage());
        }
    }
}
