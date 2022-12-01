package ru.job4j.fastfood.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Message {
    @EqualsAndHashCode.Include
    private int id;
    @EqualsAndHashCode.Include
    private String body;
    private LocalDateTime created;
    private List<Customer> receivers;
}
