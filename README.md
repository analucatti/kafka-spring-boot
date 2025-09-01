# Kafka Spring Boot Example

A comprehensive example project demonstrating Apache Kafka integration with Spring Boot, featuring Avro serialization, Schema Registry, and Kafka Streams processing.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Kafka Streams](#kafka-streams)
- [Configuration](#configuration)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This project provides a complete setup example for using Apache Kafka with Spring Boot, demonstrating real-world patterns for building event-driven microservices. It includes examples of:

- Basic producer and consumer implementation
- Avro serialization with Schema Registry
- Kafka Streams for stream processing
- Topic-to-topic message filtering and transformation
- Stream joins with windowing

## ✨ Features

- **Kafka Producer**: Send messages to Kafka topics with Avro serialization
- **Kafka Consumer**: Consume and process messages from Kafka topics
- **Schema Registry Integration**: Centralized schema management for Avro schemas
- **Kafka Streams**: Real-time stream processing with filtering and transformations
- **Stream Joins**: Demonstrate joining multiple streams with time windows
- **Docker Compose Setup**: Easy local development with Confluent Platform
- **REST API**: HTTP endpoints for triggering Kafka operations

## 🛠️ Tech Stack

- **Java** 11+
- **Spring Boot** 2.x/3.x
- **Apache Kafka**
- **Confluent Schema Registry**
- **Apache Avro**
- **Kafka Streams**
- **Docker & Docker Compose**
- **Maven**

## 📦 Prerequisites

Before running this application, ensure you have the following installed:

- Java JDK 11 or higher
- Maven 3.6+
- Docker and Docker Compose
- Git

## 📁 Project Structure

```
kafka-spring-boot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/kafka/
│   │   │       ├── config/        # Kafka configuration classes
│   │   │       ├── controller/    # REST API controllers
│   │   │       ├── producer/      # Kafka producers
│   │   │       ├── consumer/      # Kafka consumers
│   │   │       ├── streams/       # Kafka Streams processing
│   │   │       └── model/         # Data models and Avro schemas
│   │   └── resources/
│   │       ├── application.yml    # Application configuration
│   │       └── docker-compose.yml # Kafka infrastructure setup
│   └── test/                      # Unit and integration tests
├── pom.xml                         # Maven dependencies
└── README.md                       # This file
```

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/analucatti/kafka-spring-boot.git
cd kafka-spring-boot
```

### 2. Start Kafka Infrastructure

Navigate to the resources folder and start the Confluent Platform using Docker Compose:

```bash
cd src/main/resources
docker-compose up -d
```

This will start:
- Zookeeper
- Kafka Broker
- Schema Registry
- Kafka Connect (optional)
- Control Center (optional, for monitoring)

Wait for all services to be healthy:

```bash
docker-compose ps
```

### 3. Build the Application

From the project root directory:

```bash
./mvnw clean package
```

### 4. Run the Application

```bash
java -jar target/kafka-spring-boot-*.jar
```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

### Generate Random Messages

Send random sample messages to demonstrate basic producer functionality:

```bash
curl --location --request POST 'http://localhost:8080/sample'
```

### Send Message to Stream Topic 1

Send a message to the first stream topic for join demonstration:

```bash
curl --location --request POST 'http://localhost:8080/message/streamsTopic1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "First Message"
}'
```

### Send Message to Stream Topic 2

Send a message to the second stream topic for join demonstration:

```bash
curl --location --request POST 'http://localhost:8080/message/streamsTopic2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "Second Message"
}'
```

## 🌊 Kafka Streams

### Stream Processing Features

1. **Message Filtering**: Automatically filter messages based on content and route to different topics
2. **Stream-to-Stream Transfer**: Process messages from one topic and send transformed results to another
3. **Stream Joins**: Join messages from multiple topics within a 30-second time window

### Join Window Configuration

The application uses a **30-second join window** for stream operations. To test the join functionality:

1. Send a message to `streamsTopic1`
2. Within 30 seconds, send a message to `streamsTopic2`
3. The joined result will be processed and available in the output topic

## ⚙️ Configuration

### Application Properties

Key configuration properties in `application.yml`:

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    consumer:
      group-id: kafka-spring-boot-group
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: io.confluent.kafka.serializers.KafkaAvroDeserializer
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: io.confluent.kafka.serializers.KafkaAvroSerializer
    properties:
      schema.registry.url: http://localhost:8081

kafka:
  topics:
    sample-topic: sample-topic
    streams-topic-1: streamsTopic1
    streams-topic-2: streamsTopic2
    output-topic: output-topic
```

### Docker Compose Services

The `docker-compose.yml` file configures:

- **Zookeeper**: Coordination service for Kafka
- **Kafka Broker**: Message broker on port 9092
- **Schema Registry**: Avro schema management on port 8081

## 🧪 Testing

### Unit Tests

Run unit tests:

```bash
./mvnw test
```

### Integration Tests

Run integration tests (requires Docker):

```bash
./mvnw verify
```

### Manual Testing

1. Start the infrastructure and application
2. Use the provided curl commands to send messages
3. Check application logs for consumer output
4. Monitor Kafka topics using Kafka tools or Control Center

## 🔧 Troubleshooting

### Common Issues

#### Kafka Connection Issues
- Ensure Docker containers are running: `docker-compose ps`
- Check if ports 9092 (Kafka) and 8081 (Schema Registry) are available
- Verify network connectivity: `telnet localhost 9092`

#### Schema Registry Issues
- Ensure Schema Registry is running: `curl http://localhost:8081/subjects`
- Check schema compatibility settings
- Verify Avro schema definitions

#### Consumer Not Receiving Messages
- Check consumer group offset: `kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group kafka-spring-boot-group`
- Verify topic exists: `kafka-topics --bootstrap-server localhost:9092 --list`
- Check application logs for errors

### Useful Commands

```bash
# List all topics
docker exec -it kafka kafka-topics --list --bootstrap-server localhost:9092

# Describe a topic
docker exec -it kafka kafka-topics --describe --topic sample-topic --bootstrap-server localhost:9092

# View consumer groups
docker exec -it kafka kafka-consumer-groups --list --bootstrap-server localhost:9092

# Reset consumer group offset
docker exec -it kafka kafka-consumer-groups --bootstrap-server localhost:9092 --group kafka-spring-boot-group --reset-offsets --to-earliest --all-topics --execute
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Ana Lucatti**

- GitHub: [@analucatti](https://github.com/analucatti)

## 🙏 Acknowledgments

- [Spring Kafka Documentation](https://spring.io/projects/spring-kafka)
- [Confluent Platform Documentation](https://docs.confluent.io/)
- [Apache Kafka Documentation](https://kafka.apache.org/documentation/)

---

⭐ If you find this project helpful, please give it a star on GitHub!
