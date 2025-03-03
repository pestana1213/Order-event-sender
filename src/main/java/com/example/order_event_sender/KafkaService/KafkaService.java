package com.example.order_event_sender.KafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // Method to send messages to a topic
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
