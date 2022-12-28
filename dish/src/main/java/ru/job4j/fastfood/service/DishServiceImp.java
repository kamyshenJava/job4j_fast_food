package ru.job4j.fastfood.service;

import org.springframework.stereotype.Service;
import ru.job4j.fastfood.model.Dish;
import ru.job4j.fastfood.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImp implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImp(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public boolean editDish(int id, Dish dish) {
        Optional<Dish> dishOptional = dishRepository.findById(id);
        if (dishOptional.isPresent()) {
            Dish dishDB = dishOptional.get();
            dishDB.setName(dish.getName());
            dishDB.setIngredients(dish.getIngredients());
            dishRepository.save(dishDB);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDish(int id) {
        Optional<Dish> dishOptional = dishRepository.findById(id);
        if (dishOptional.isPresent()) {
            dishRepository.delete(dishOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Dish findById(int id) {
        return dishRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Dish> findByName(String name) {
        return dishRepository.findByName(name);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }
}
