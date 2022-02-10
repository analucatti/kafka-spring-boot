package com.victorromano.kafkaspringboot.kafka;

import com.victorromano.avro.kafkaspringboot.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleKafkaProducer {
    private final KafkaTemplate<String, Value> kafkaTemplate;

    @Autowired
    public SampleKafkaProducer(KafkaTemplate<String, Value> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @org.springframework.beans.factory.annotation.Value("{$kafka.spring.boot.project.topic1}")
    private String topic1;

    public String send(String key, String message) {
        return send(key, message, topic1);
    }

    public String send(String key, String message, String topic) {
        Value avroMessage = Value.newBuilder()
                .setMessage(message)
                .build();

        kafkaTemplate.send(topic, key, avroMessage);
        return message;
    }

}
