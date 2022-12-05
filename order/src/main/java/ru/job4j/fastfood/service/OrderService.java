package ru.job4j.fastfood.service;

import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.model.OrderStatus;

public interface OrderService {
    boolean placeOrder(Order order);
    boolean changeOrder(Order order);
    boolean cancelOrder(Order order);
    OrderStatus getStatus(Order order);
}