package com.prabidhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestKafkaSpringbootMultimoduleApplication {

	public static void main(String[] args) {
		SpringApplication.from(KafkaSpringbootMultimoduleApplication::main).with(TestKafkaSpringbootMultimoduleApplication.class).run(args);
	}

}
