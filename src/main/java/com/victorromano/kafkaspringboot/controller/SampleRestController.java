package com.victorromano.kafkaspringboot.controller;

import com.victorromano.kafkaspringboot.kafka.SampleKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SampleRestController {

    private final SampleKafkaProducer producer;

    @Autowired
    public SampleRestController(SampleKafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/sample")
    public ResponseEntity<String> sample() {
        return ResponseEntity.status(HttpStatus.OK).body(producer.send(UUID.randomUUID().toString(), Long.toString(System.currentTimeMillis())));
    }

    @PostMapping("/message/{topic}")
    public ResponseEntity<String> message(@RequestBody MessageDto messageDto, @PathVariable String topic) {
        return ResponseEntity.status(HttpStatus.OK).body(producer.send(UUID.randomUUID().toString(), messageDto.getMessage(), topic));
    }

}
