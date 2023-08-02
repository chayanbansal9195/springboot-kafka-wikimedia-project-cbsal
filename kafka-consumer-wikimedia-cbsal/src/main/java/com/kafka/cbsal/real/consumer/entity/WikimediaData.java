package com.kafka.cbsal.real.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Table(name="wikimedia_recent_change")
@Getter
@Setter
public class WikimediaData {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long Id;
	
	@Lob
	private String wikiEventData;
}
