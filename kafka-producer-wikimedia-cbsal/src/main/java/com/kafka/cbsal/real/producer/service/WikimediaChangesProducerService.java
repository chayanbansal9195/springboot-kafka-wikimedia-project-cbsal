package com.kafka.cbsal.real.producer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.cbsal.real.producer.handlers.WikimediaChangesHandlers;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangesProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducerService.class);

	KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaChangesProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage() throws InterruptedException {
		String topic = "wikimedia_recent_change_topic";

		// to read realtime stream data from wikimedia, we use event source
		// we need to add couple of libraries

		EventHandler eventHandler = new WikimediaChangesHandlers(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
	}

}
