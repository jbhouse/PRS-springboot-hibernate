package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Product;
import entities.Vendor;
import repositories.VendorRepository;

@RestController
@RequestMapping("/Vendors")
//@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody Vendor show(@PathVariable Long id) {
		return this.vendorRepository.findOne(id);
	}

    @GetMapping("/All")
	public @ResponseBody Iterable<Vendor> index() {
    	return vendorRepository.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	Vendor vendor = this.vendorRepository.findOne(id);
        if(vendor != null) {
        	this.vendorRepository.delete(vendor);
        }
    }
    
}