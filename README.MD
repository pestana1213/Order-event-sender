# Order Service

A Spring Boot application that handles order management via REST APIs and publishes events to Kafka topics.

## Overview

This service provides endpoints to create, update, and delete orders. Each action publishes an event to a Kafka topic:
- `create-order`: When an order is created.
- `update-order`: When an order's status is updated.
- `delete-order`: When an order is deleted.

### Kafka Setup (Local)
1. Start Zookeeper & Kafka Server
   Navigate to your Kafka directory (e.g., cd /kafka) and run:

# Start Zookeeper (in a new terminal)
- `bin\windows\zookeeper-server-start.bat config\zookeeper.properties`

# Start Kafka Server (in another terminal)
- `bin\windows\kafka-server-start.bat config\server.properties`


# Create Kafka Topics
   Create the required topics for order events:

- `bin\windows\kafka-topics.bat --create --topic create-order --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1`
- `bin\windows\kafka-topics.bat --create --topic update-order --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1`
- `bin\windows\kafka-topics.bat --create --topic delete-order --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1`