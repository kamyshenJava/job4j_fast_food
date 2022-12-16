package ru.job4j.fastfood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fastfood.model.Dish;
import ru.job4j.fastfood.service.DishService;

import java.util.List;

@RestController
@RequestMapping(value = "/dish")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/")
    public Dish addDish(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editDish(@PathVariable int id, @RequestBody Dish dish) {
        boolean status = dishService.editDish(id, dish);
        return ResponseEntity.status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeDish(@PathVariable int id) {
        boolean status = dishService.removeDish(id);
        return ResponseEntity.status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/findById/{id}")
    public Dish findById(@PathVariable int id) {
        return dishService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<Dish> findByName(@PathVariable String name) {
        return dishService.findByName(name);
    }

    @GetMapping("/findAll")
    public List<Dish> findAll() {
        return dishService.findAll();
    }
}
