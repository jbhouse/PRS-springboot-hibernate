package controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Product;
import entities.Vendor;
import repositories.ProductRepository;

@RestController
@RequestMapping("/Products")
//@ComponentScan(basePackages = {"contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
    @GetMapping("/All")
    public Iterable<Product> index() {
        return productRepository.findAll();
    }
	
	@GetMapping(value = "/{id}")
	public Product show(@PathVariable Long id) {
		return this.productRepository.findOne(id);
	}
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	Product product = this.show(id);
        if(product != null) {
        	this.productRepository.delete(product);
        }
    }

}