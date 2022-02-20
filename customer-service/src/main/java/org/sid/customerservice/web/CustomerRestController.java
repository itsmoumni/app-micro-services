package org.sid.customerservice.web;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/customers/{id}")
    public Customer publish(@PathVariable(name = "id") Long customerId){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer != null){
            streamBridge.send("CUSTOMER-TOPIC",customer);
        }
        return customer;
    }

}
