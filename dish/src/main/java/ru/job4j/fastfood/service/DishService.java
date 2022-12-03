package ru.job4j.fastfood.service;

import ru.job4j.fastfood.model.Dish;

public interface DishService {
    void addDish(Dish dish);
    void editDish(Dish dish);
    void removeDish(Dish dish);
}
