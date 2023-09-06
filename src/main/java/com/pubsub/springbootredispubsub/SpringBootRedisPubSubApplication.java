package com.pubsub.springbootredispubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SpringBootRedisPubSubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisPubSubApplication.class, args);
    }

}
