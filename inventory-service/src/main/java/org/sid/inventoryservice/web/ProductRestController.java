package org.sid.inventoryservice.web;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/products/{id}")
    public Product publish(@PathVariable(name="id") Long productId){
        Product product = productRepository.findById(productId).orElse(null);
        if(product != null){
            streamBridge.send("PRODUCT-TOPIC",product);
        }
        return product;
    }

    /*@GetMapping(path="/")
    public String index(){
        return "index";
    }

    @GetMapping(path="/products")
    public String products(Model model){
        model.addAttribute("products",productRepository.findAll());
        return "products";
    }

    @GetMapping(path="/suppliers")
    public String suppliers(){
        return "suppliers";
    }*/

}
