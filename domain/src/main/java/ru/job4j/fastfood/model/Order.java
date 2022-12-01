package ru.job4j.fastfood.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {
    @EqualsAndHashCode.Include
    private int id;
    @EqualsAndHashCode.Include
    private Customer customer;
    @EqualsAndHashCode.Include
    private List<Dish> dishes;
    @EqualsAndHashCode.Include
    private Double price;
    private boolean isPaid;
    private boolean isDelivered;
}
