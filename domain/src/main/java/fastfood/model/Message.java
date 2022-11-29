package fastfood.model;

import lombok.Data;

import java.util.List;

@Data
public class Message {
    private int id;
    private String body;
    private List<Customer> receivers;
}
