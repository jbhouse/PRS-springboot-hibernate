package web;

import org.springframework.web.bind.annotation.RestController;

import domain.product.Product;
import domain.product.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/Products")
@EntityScan("domain")
@EnableJpaRepositories("domain")
public class ProductController extends BaseController {
	
	@Autowired
	private ProductRepository productRepository;
	
    @GetMapping("/List")
    public Iterable<Product> index() {
        return productRepository.findAll();
    }
	
	@GetMapping(value = "/{id}")
	public List<Product> show(@PathVariable Long id) {
		return getReturnArray(this.productRepository.findOne(id));
	}
    
    @PostMapping("/Add")
    public @ResponseBody Product add (@RequestBody Product product) {
        productRepository.save(product);
        System.out.println("Vendor saved:  "+product);
        return product;
    }
	
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	Product product = this.productRepository.findOne(id);
        if(product != null) {
        	this.productRepository.delete(product);
        }
    }

}