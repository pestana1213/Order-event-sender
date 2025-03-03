package com.example.order_event_sender.Controller;

import com.example.order_event_sender.KafkaService.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final String CREATE_ORDER = "create-order";
    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/create")
    public void createOrder(){
        kafkaService.sendMessage(CREATE_ORDER, "New message");
    }
}
