package com.victorromano.kafkaspringboot.streams;

import com.victorromano.avro.kafkaspringboot.Key;
import com.victorromano.avro.kafkaspringboot.Value;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Component;

@Component
@EnableKafkaStreams
public class SampleKafkaStreams {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleKafkaStreams.class);

    @org.springframework.beans.factory.annotation.Value("${kafka.topic}")
    private String topicName;

    @org.springframework.beans.factory.annotation.Value("${kafka.streams.topic}")
    private String streamsTopicName;

    @Bean
    public KStream<Key, Value> testStream(StreamsBuilder kStreamBuilder) {
        KStream<Key, Value> stream = kStreamBuilder.stream(topicName);
        stream
            .peek((key, value) -> LOGGER.info("Streaming message '{}'", value.getMessage()))
            .filter((key, value) -> value.getMessage().contains("a"))
            .peek((key, value) -> LOGGER.info("Message '{}' passed filtering", value.getMessage()))
            .to(streamsTopicName);

        return stream;
    }

}
