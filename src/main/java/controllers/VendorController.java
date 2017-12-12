package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Vendor;
import repositories.VendorRepository;

@RestController
@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping(value = "/Vendors/{id}")
	public @ResponseBody Vendor getVendorById(@PathVariable Integer id) {
		return this.vendorRepository.findOne(id);
	}

    @GetMapping("/Vendors/All")
	public @ResponseBody Iterable<Vendor> getAllVendors() {
    	return vendorRepository.findAll();
    }

}