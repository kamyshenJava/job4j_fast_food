package ru.job4j.fastfood.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BonusCard {
    @EqualsAndHashCode.Include
    private int id;
    @EqualsAndHashCode.Include
    private int number;
    private Customer customer;
}
