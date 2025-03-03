package com.example.order_event_sender.Controller;

import com.example.order_event_sender.KafkaService.KafkaService;
import com.example.order_event_sender.Order.Order;
import com.example.order_event_sender.Order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final String CREATE_ORDER = "create-order";
    private static final String UPDATE_ORDER = "update-order";
    private static final String DELETE_ORDER = "delete-order";

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order){
        kafkaService.sendMessage(CREATE_ORDER, order.toString());
    }

    @PostMapping("{orderId}/update")
    public void updateOrderStatus(@RequestParam String orderId, @RequestParam String status) throws Exception {
        try {
            OrderStatus statusEnum = OrderStatus.valueOf(status);
            kafkaService.sendMessage(UPDATE_ORDER, orderId + " " + statusEnum.getDescription());
        }
        catch (IllegalArgumentException e) {
            throw new Exception("Status not valid");
        }
    }

    @PostMapping("{orderId}/delete")
    public void deleteOrder(@RequestParam String orderId) {
        kafkaService.sendMessage(DELETE_ORDER, orderId);
    }
}
