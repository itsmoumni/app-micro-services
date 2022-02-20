package org.sid.billingservice.web;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductRestClient;
import org.sid.billingservice.model.Customer.Customer;
import org.sid.billingservice.model.Product.Product;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;


    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;

    }


    @GetMapping(path = "/bill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill = billRepository.findById(id).orElse(null);
        if(bill != null){
            Customer customer = customerRestClient.getCustomerById(bill.getCustomerID());
            bill.setCustomer(customer);

            bill.getProductItems().forEach(productItem -> {
                Product product = productRestClient.getProductById(productItem.getProductID());
                //p1.setProduct(product);
                productItem.setProductName(product.getName());
            });
        }
        return bill;
    }

    @GetMapping(path="/bills")
    public List<Bill> getAllBills(){
        List<Bill> bills = billRepository.findAll();
        return bills;
    }
}
