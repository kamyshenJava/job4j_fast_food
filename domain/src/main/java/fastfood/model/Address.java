package fastfood.model;

import lombok.Data;

@Data
public class Address {
    private int id;
    private String street;
    private String building;
    private String apartment;
}
