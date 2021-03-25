package com.victorromano.kafkaspringboot.kafka;

import com.victorromano.avro.kafkaspringboot.Key;
import com.victorromano.avro.kafkaspringboot.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleKafkaProducer {

    private KafkaTemplate<Key, Value> kafkaTemplate;

    @org.springframework.beans.factory.annotation.Value("${kafka.topic}")
    private String topicName;

    @Autowired
    public SampleKafkaProducer(KafkaTemplate<Key, Value> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String send(String key, String message) {
        Key avroKey = Key.newBuilder()
            .setKey(key)
            .build();

        Value avroMessage = Value.newBuilder()
            .setMessage(message)
            .build();

        kafkaTemplate.send(topicName, avroKey, avroMessage);
        return message;
    }

}
