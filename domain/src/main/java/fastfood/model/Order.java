package fastfood.model;

import lombok.Data;

import java.util.List;
@Data
public class Order {
    private int id;
    private Customer customer;
    private List<Dish> dishes;
    private Double price;
    private boolean isPaid;
    private boolean isDelivered;
}
