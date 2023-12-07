package com.prabidhi;

import com.prabidhi.service.WikimediaChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	// in order to run WikimediaChangesProducer a service class, we need to class sendMessage()
	// sendMessage method we created @serviceclass and is producer
	// we implement commandline runner interface that provides
	// run method, this run method execute with every program is executed
	// we put send message in that run method



	@Autowired //42.37 mins video clip
	private WikimediaChangesProducer wikimediaChangesProducer;

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducer.sendMessage();
	}
}
