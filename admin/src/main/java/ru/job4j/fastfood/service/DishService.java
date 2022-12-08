package ru.job4j.fastfood.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.fastfood.model.Dish;

import java.util.Collections;
import java.util.List;

@Service
public class DishService {
    @Value("${api-url}")
    private String url;
    private final RestTemplate restTemplate;

    public DishService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean addDish(Dish dish) {
        return restTemplate.postForEntity(url, dish, Void.class).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public boolean editDish(String id, Dish dish) {
        return restTemplate.exchange(String.format("%s/%s", url, id), HttpMethod.PUT, new HttpEntity<>(dish),
                Void.class).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public boolean removeDish(String id) {
        return restTemplate.exchange(String.format("%s/%s", url, id), HttpMethod.DELETE, HttpEntity.EMPTY,
                Void.class).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public Dish findById(String id) {
        return restTemplate.getForObject(String.format("%s/findById/%s", url, id), Dish.class);
    }

    public List<Dish> findByName(String name) {
        return getList(String.format("%s/findByName/%s", url, name));
    }

    public List<Dish> findAll() {
        return getList(String.format("%s/findAll", url));
    }

    private List<Dish> getList(String url) {
        List<Dish> body = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }
}
