package com.springkafka.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaProducer {
    private final String topicName = "my-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send(topicName, msg);
    }

    public void sendMessageForResult(String msg) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=" + msg + " with offset=" + result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to send message=[" + msg + "] due to : " + ex.getMessage());
            }
        });

    }
}
