package com.kafka.cbsal.real.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.cbsal.real.consumer.entity.WikimediaData;
import com.kafka.cbsal.real.consumer.repository.WikimediaDataRepository;

@Service
public class WikimediaConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaConsumerService.class);

	private WikimediaDataRepository wikimediaDataRepository;

	public WikimediaConsumerService(WikimediaDataRepository wikimediaDataRepository) {
		this.wikimediaDataRepository = wikimediaDataRepository;
	}

	@KafkaListener(topics = "wikimedia_recent_change_topic", groupId = "ConsumerGroupId")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Event Message Received --> %s", eventMessage));
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		wikimediaDataRepository.save(wikimediaData);
	}
}
