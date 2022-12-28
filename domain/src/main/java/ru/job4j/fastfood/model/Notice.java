package ru.job4j.fastfood.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "notices")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String body;
}
