package ru.job4j.fastfood.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dish {
    @EqualsAndHashCode.Include
    private int id;
    @EqualsAndHashCode.Include
    private String name;
    private List<Ingredient> ingredients;
}
