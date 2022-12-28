package ru.job4j.fastfood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fastfood.model.Order;
import ru.job4j.fastfood.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeOrder(@PathVariable int id, @RequestBody Order order) {
        boolean status = orderService.changeOrder(id, order);
        return ResponseEntity.status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelOrder(@PathVariable int id) {
        boolean status = orderService.cancelOrder(id);
        return ResponseEntity.status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<?> getStatus(@PathVariable int id) {
        String status = orderService.getStatus(id).toString();
        return ResponseEntity.ok(status);
    }

}
