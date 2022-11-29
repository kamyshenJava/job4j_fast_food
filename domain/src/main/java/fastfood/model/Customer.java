package fastfood.model;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private int id;
    private String name;
    private Address address;
    private String phoneNumber;
    private List<Order> orders;
}
