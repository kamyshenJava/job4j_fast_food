package ru.job4j.fastfood.service;

import org.springframework.stereotype.Service;
import ru.job4j.fastfood.model.Dish;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InMemDishService implements DishService {

    private Map<Integer, Dish> dishes = new HashMap<>();

    @Override
    public boolean addDish(Dish dish) {
        return true;
    }

    @Override
    public boolean editDish(int id, Dish dish) {
        return true;
    }

    @Override
    public boolean removeDish(int id) {
        return true;
    }

    @Override
    public Dish findById(int id) {
        return new Dish();
    }

    @Override
    public List<Dish> findByName(String name) {
        return Collections.emptyList();
    }

    @Override
    public List<Dish> findAll() {
        return Collections.emptyList();
    }
}
