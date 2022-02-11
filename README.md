# Kafka Spring Boot
Project with setup example to use Kafka with Avro and Schema Registry with Spring Boot using a basic consumer, producer and stream between 2 topics filtering a message.

# Testing the Project

## Environment Setup
Start Kafka with using Landoop's [`fast-data-env`](https://hub.docker.com/r/landoop/fast-data-dev) Docker container.
```
docker run --name kafka \
   --net=host \
   -e SAMPLEDATA=0 \
   -d landoop/fast-data-dev
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
To your own message to topic:
```
curl --location --request POST 'http://localhost:8080/message' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "Test my kafka application"
}'
```