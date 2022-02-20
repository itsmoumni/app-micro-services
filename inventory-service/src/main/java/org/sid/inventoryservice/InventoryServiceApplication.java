package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){

		repositoryRestConfiguration.exposeIdsFor(Product.class);

		return args->{
			productRepository.save(new Product(null,"MacBook Pro 2020",19999,3));
			productRepository.save(new Product(null,"EPSON Printer",3490,8));
			productRepository.save(new Product(null,"iPhone XS",8990,6));

			productRepository.findAll().forEach(product -> {
				System.out.println(product.getName());
			});
		};
	}
}
