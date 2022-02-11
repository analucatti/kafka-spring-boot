package com.victorromano.kafkaspringboot.controller;

import com.victorromano.kafkaspringboot.kafka.SampleKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SampleRestController {

    private final SampleKafkaProducer producer;

    @PostMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sample() {
        return ResponseEntity.status(HttpStatus.OK).body(producer.send(UUID.randomUUID().toString(), Long.toString(System.currentTimeMillis())));
    }

    @PostMapping(value = "/message/{topic}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> message(@RequestBody MessageDto messageDto, @PathVariable String topic) {
        return ResponseEntity.status(HttpStatus.OK).body(producer.send("9a394b6d-731c-4026-97ea-2e5f9619fec4", messageDto.getMessage(), topic));
    }

}
