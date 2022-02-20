package org.sid.billingservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.sid.billingservice.model.Product.Product;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;
    private double price;
    private long productID;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    @Transient
    private Product product;
    @Transient
    private String productName;
}
