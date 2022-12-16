package ru.job4j.fastfood.service;

import ru.job4j.fastfood.model.Dish;

import java.util.List;

public interface DishService {
    Dish addDish(Dish dish);
    boolean editDish(int id, Dish dish);
    boolean removeDish(int id);
    Dish findById(int id);
    List<Dish> findByName(String name);
    List<Dish> findAll();

}
