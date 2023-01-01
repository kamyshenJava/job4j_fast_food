package ru.job4j.fastfood.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.model.KitchenNotice;
import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.repository.KitchenNoticeRepository;

import static ru.job4j.fastfood.model.OrderStatus.CANNOT_BE_COOKED;
import static ru.job4j.fastfood.model.OrderStatus.READY_FOR_DELIVERY;

@Service
public class KitchenService {

    private final KitchenNoticeRepository kitchenNoticeRepository;
    private final KafkaTemplate<Integer, Order> kafkaTemplate;

    public KitchenService(KitchenNoticeRepository kitchenNoticeRepository, KafkaTemplate<Integer, Order> kafkaTemplate) {
        this.kitchenNoticeRepository = kitchenNoticeRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = {"preorder"})
    public void handleOrder(ConsumerRecord<Integer, Order> input) throws InterruptedException {
        KitchenNotice kitchenNotice = new KitchenNotice();
        Order order = input.value();
        kitchenNotice.setBody(String.format("The order %s has been received", order.toString()));
        kitchenNoticeRepository.save(kitchenNotice);
        cook(order);
    }

    private void cook(Order order) throws InterruptedException {
        boolean possibleToCook = order.getDishes().stream()
                .noneMatch(o -> "pizza".equals(o.getName()));
        if (possibleToCook) {
            Thread.sleep(60000);
            order.setOrderStatus(READY_FOR_DELIVERY);
        } else {
            order.setOrderStatus(CANNOT_BE_COOKED);
        }
        kafkaTemplate.send("cooked_order", order.getId(), order);
    }
}
