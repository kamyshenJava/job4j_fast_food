package ru.job4j.fastfood.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.service.OrderService;

@Controller
public class KafkaController {
    private final OrderService orderService;

    public KafkaController(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = {"cooked_order"})
    public void listener(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        orderService.updateStatus(order);
    }
}
