package com.prabidhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestKafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.from(KafkaConsumerApplication::main).with(TestKafkaConsumerApplication.class).run(args);
    }

}
