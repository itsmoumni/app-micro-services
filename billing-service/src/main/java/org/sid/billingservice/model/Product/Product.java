package org.sid.billingservice.model.Product;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Product {
    private Long id;
    private String name;
    private double price;
    private double quantity;
}
