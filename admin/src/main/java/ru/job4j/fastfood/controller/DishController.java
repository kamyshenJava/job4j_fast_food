package ru.job4j.fastfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fastfood.model.Dish;
import ru.job4j.fastfood.service.DishService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/dish")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }
    @GetMapping("/")
    public String index(Model model, @RequestParam(name = "name", required = false, defaultValue = "") String name) {
        if ("".equals(name)) {
            model.addAttribute("dishes", dishService.findAll());
        } else {
            model.addAttribute("dishes", dishService.findByName(name));
        }
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Dish dish) {
        dishService.addDish(dish);
        return "redirect:/dish/";
    }
    @GetMapping("/{id}")
    public String dish(Model model, @PathVariable("id") int id) {
        Dish dish = dishService.findById(String.valueOf(id));
        model.addAttribute("dish", dish);
        return "dish";
    }
    @PostMapping("/remove")
    public String remove(HttpServletRequest req) {
        String id = req.getParameter("id");
        dishService.removeDish(id);
        return "redirect:/dish/";
    }

    @PostMapping("/edit")
    public String edit(HttpServletRequest req, @ModelAttribute Dish dish) {
        String id = req.getParameter("id");
        dishService.editDish(id, dish);
        return String.format("redirect:/dish/%s", id);
    }
    @PostMapping("/findByName")
    public String findByName(HttpServletRequest req) {
        String name = req.getParameter("name");
        return String.format("redirect:/dish/?name=%s", name);
    }
}
