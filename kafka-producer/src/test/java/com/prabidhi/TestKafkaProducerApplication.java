package com.prabidhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.from(KafkaProducerApplication::main).with(TestKafkaProducerApplication.class).run(args);
	}

}
