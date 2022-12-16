package ru.job4j.fastfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MainAdmin {

    public static void main(String[] args) {
        SpringApplication.run(MainAdmin.class, args);
    }
}
