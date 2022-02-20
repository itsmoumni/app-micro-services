package org.sid.billingservice.services;

import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.feign.ProductRestClient;
import org.sid.billingservice.model.Customer.Customer;
import org.sid.billingservice.model.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class BillingService {

    @Bean
    public Consumer<Product> productConsumer(){
        return (product)-> {
            System.out.println("***************************");
            System.out.println(product.getName());
            System.out.println("***************************");
        };
    }

    /*@Bean
    public Consumer<List<Product>> productsConsumer(){
        return (products) -> {
            for(Product product:products){
                System.out.println("***************************");
                System.out.println(product);
                System.out.println("***************************");
            }
        };
    }*/


    @Bean
    public Consumer<Customer> customerConsumer(){
        return (customer)->{
            System.out.println("***************************");
            System.out.println(customer.getName());
            System.out.println("***************************");
        };
    }

    /*
    @Bean
    public Consumer<List<Customer>> customersConsumer(){
        return (customers) -> {
            for(Customer customer : customers){
                System.out.println("***************************");
                System.out.println(customer);
                System.out.println("***************************");
            }
        };
    }*/
}
