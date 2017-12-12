package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Product;
import repositories.ProductRepository;

@RestController
@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/Products/{id}")
	public @ResponseBody Product getProductById(@PathVariable Integer id) {
		return this.productRepository.findOne(id);
	}

    @GetMapping("/Products/All")
	public @ResponseBody Iterable<Product> getAllProducts() {
    	return productRepository.findAll();
    }

}