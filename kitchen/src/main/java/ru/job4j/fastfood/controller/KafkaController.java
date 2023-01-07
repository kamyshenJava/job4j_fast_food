package ru.job4j.fastfood.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.service.KitchenService;

import java.util.concurrent.ExecutionException;

@Controller
public class KafkaController {

    private final KitchenService kitchenService;

    public KafkaController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @KafkaListener(topics = {"preorder"})
    public void listener(ConsumerRecord<Integer, Order> input) throws ExecutionException, InterruptedException {
        Order order = input.value();
        kitchenService.handleOrder(order);
    }
}
