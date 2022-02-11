package com.victorromano.kafkaspringboot.kafka;

import com.victorromano.avro.kafkaspringboot.Key;
import com.victorromano.avro.kafkaspringboot.Value;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleKafkaProducer.class);
    private final KafkaTemplate<Key, Value> kafkaTemplate;

    @org.springframework.beans.factory.annotation.Value("${kafka.topic}")
    private String topicName;

    public String send(String key, String message) {
        Key avroKey = Key.newBuilder()
                .setKey(key)
                .build();

        Value avroMessage = Value.newBuilder()
                .setMessage(message)
                .build();

        kafkaTemplate.send(topicName, avroKey, avroMessage);
        LOGGER.info("Sent message {} to topic {}", message, topicName);
        return avroMessage.toString();
    }

}
