package com.kafka.cbsal.real.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.cbsal.real.producer.service.WikimediaChangesProducerService;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {
	public static void main(String Args[]) {
		SpringApplication.run(SpringBootProducerApplication.class);
	}

	@Autowired
	private WikimediaChangesProducerService wikimediaChangesProducerService;

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducerService.sendMessage();
	}

}
