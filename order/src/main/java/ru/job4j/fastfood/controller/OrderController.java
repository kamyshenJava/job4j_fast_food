package ru.job4j.fastfood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/order")
public class OrderController {

    @PostMapping("/")
    public ResponseEntity<?> placeOrder() {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeOrder(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelOrder(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<?> getStatus(@PathVariable int orderId) {
        return null;
    }

}
