package org.sid.billingservice.feign;

import org.sid.billingservice.model.Product.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping(path = "/products")
    //PagedModel<Product> getPagedProducts(@RequestParam(name="page") int page, @RequestParam(name="size") int size);
    PagedModel<Product> getPagedProducts();
    @GetMapping(path="/products/{id}")
    Product getProductById(@PathVariable(name = "id") Long id);
}
