package service;

import fastfood.model.Dish;

public interface DishService {
    void addDish(Dish dish);
    void editDish(Dish dish);
    void removeDish(Dish dish);
}
