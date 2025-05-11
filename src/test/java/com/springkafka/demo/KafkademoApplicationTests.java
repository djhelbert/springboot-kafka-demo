package com.springkafka.demo;

import com.springkafka.demo.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaDemoApplicationTests {

	@Autowired
	KafkaProducer kafkaProducer;

	@Test
	void contextLoads() {
	}

	@Test
	void send() {
		kafkaProducer.sendMessage("Signal transmitted message received.");
	}
}
