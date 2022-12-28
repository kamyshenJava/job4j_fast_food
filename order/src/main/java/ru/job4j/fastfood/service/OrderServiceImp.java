package ru.job4j.fastfood.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.model.OrderStatus;
import ru.job4j.fastfood.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {

    private final KafkaTemplate<Integer, String> kafkaTemplate;
    private final OrderRepository orderRepository;

    public OrderServiceImp(KafkaTemplate<Integer, String> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(Order order) {
        Order orderDb = orderRepository.save(order);
        kafkaTemplate.send("messengers", orderDb.getId(),
                String.format("Order %d has been placed", orderDb.getId()));
        return orderDb;
    }

    @Override
    public boolean changeOrder(int id, Order order) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order orderDB = orderOptional.get();
            orderDB.setDishes(order.getDishes());
            orderDB.setPrice(order.getPrice());
            orderDB.setOrderStatus(order.getOrderStatus());
            orderRepository.save(orderDB);
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelOrder(int id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            orderRepository.delete(orderOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public OrderStatus getStatus(int id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.map(Order::getOrderStatus).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
