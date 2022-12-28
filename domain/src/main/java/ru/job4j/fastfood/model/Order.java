package ru.job4j.fastfood.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "orders")
public class Order {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include
    private List<Dish> dishes;

    @EqualsAndHashCode.Include
    private Double price;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
