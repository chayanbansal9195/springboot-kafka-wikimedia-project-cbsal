package com.kafka.cbsal.real.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.cbsal.real.consumer.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
