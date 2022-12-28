package ru.job4j.fastfood.service;

import ru.job4j.fastfood.model.Dish;
import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.model.OrderStatus;

public interface OrderService {
    Order placeOrder(Order order);
    boolean changeOrder(int id, Order order);
    boolean cancelOrder(int id);
    OrderStatus getStatus(int id);
    Order findById(int id);
}