package com.springkafka.demo.consumer;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "my-topic", groupId = "kafkademo")
public class KafkaConsumer {
    @KafkaHandler(isDefault = true)
    public void process(String message) {
        System.out.println("Received Message in group: " + message);
    }
}
