# Kafka Spring Boot
Project with setup example to use Kafka with Avro and Schema Registry with Spring Boot using a basic consumer, producer 
and stream between 2 topics filtering a message and sending it to another topic.

# Testing the Project

## Environment Setup

Dependencies:
#### [`JDK 17`](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
#### [`Maven 3.8.4`](https://maven.apache.org/docs/3.8.4/release-notes.html)

Start Kafka with using Confluent:
#### [`cp-zookeeper`](https://hub.docker.com/r/confluentinc/cp-zookeeper)
#### [`cp-server`](https://hub.docker.com/r/confluentinc/cp-server)
#### [`cp-kafka`](https://hub.docker.com/r/confluentinc/cp-kafka)
#### [`cp-schema-registry`](https://hub.docker.com/r/confluentinc/cp-schema-registry)
#### [`control-center`](https://hub.docker.com/r/confluentinc/cp-enterprise-control-center)


In the project resources folder, run:
```
docker-compose up
```

## Build
```
cd kafka-spring-boot
./mvnw clean package
```

## Run
```
java -jar target/kafka-spring-boot-*.jar
```

## Test
To generate random messages to topic:
```
curl --location --request POST 'http://localhost:8080/sample'
```
To kafka streams with join, send 2 messages in 2 different topics. Note that the Join Window in 30 seconds
```
curl --location --request POST 'http://localhost:8080/message/streamsTopic1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "First Message"
}'
```
```
curl --location --request POST 'http://localhost:8080/message/streamsTopic2' \
--header 'Content-Type: application/json' \
--data-raw '{
"message": "Second Message"
}'
```
