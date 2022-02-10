package com.victorromano.kafkaspringboot.streams;

import com.victorromano.avro.kafkaspringboot.Key;
import com.victorromano.avro.kafkaspringboot.Value;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@EnableKafkaStreams
public class SampleKafkaStreams {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleKafkaStreams.class);

    @org.springframework.beans.factory.annotation.Value("${kafka.spring.boot.project.topic1}")
    private String topic1;

    @org.springframework.beans.factory.annotation.Value("${kafka.spring.boot.project.topic2}")
    private String topic2;

    @org.springframework.beans.factory.annotation.Value("${kafka.spring.boot.project.topic3}")
    private String topic3;

    @Bean
    public KStream<Key, Value> streamJoin(StreamsBuilder kStreamBuilder) {
        KStream<Key, Value> streamTopic1 = kStreamBuilder.stream(topic1);
        KStream<Key, Value> streamTopic2 = kStreamBuilder.stream(topic2);

        streamTopic1
                .peek((key, value) -> LOGGER.info("Message '{}' from topic 1", value.getMessage()))
                .join(streamTopic2,
                        (key, value) -> Value.newBuilder()
                                .setMessage(value.getMessage())
                                .build(), JoinWindows.of(Duration.ofSeconds(30)))
                .peek((key, value) -> LOGGER.info("Message '{}' from topic 2", value.getMessage()))
                .to(topic3);
        LOGGER.info("Message sent topic 3");
        return streamTopic1;
    }

}
