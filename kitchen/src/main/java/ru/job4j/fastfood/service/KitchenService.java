package ru.job4j.fastfood.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.model.KitchenNotice;
import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.repository.KitchenNoticeRepository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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


    public void handleOrder(Order order) throws ExecutionException, InterruptedException {
        KitchenNotice kitchenNotice = new KitchenNotice();
        kitchenNotice.setBody(String.format("The order %s has been received", order.toString()));
        kitchenNoticeRepository.save(kitchenNotice);
        cook(order);
    }

    private void cook(Order order) throws ExecutionException, InterruptedException {
        boolean possibleToCook = order.getDishes().stream()
                .noneMatch(dish -> "pizza".equals(dish.getName()));
        if (possibleToCook) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                order.setOrderStatus(READY_FOR_DELIVERY);
            });
            future.get();
        } else {
            order.setOrderStatus(CANNOT_BE_COOKED);
        }
        kafkaTemplate.send("cooked_order", order.getId(), order);
    }
}
