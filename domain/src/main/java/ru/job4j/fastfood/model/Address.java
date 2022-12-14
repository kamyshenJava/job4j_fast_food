package ru.job4j.fastfood.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String building;
    private String apartment;
}
