package ru.job4j.fastfood.service;

import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.model.OrderStatus;

public interface OrderService {
    void placeOrder(Order order);
    void changeOrder();
    void cancelOrder();
    OrderStatus getStatus(Order order);
}