package org.sid.billingservice.model.Customer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
}
