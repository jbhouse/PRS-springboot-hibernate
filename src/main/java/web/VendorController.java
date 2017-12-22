package web;

import org.springframework.web.bind.annotation.RestController;

import domain.vendor.Vendor;
import domain.vendor.VendorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/Vendors")
@EntityScan("domain")
@EnableJpaRepositories("domain")
public class VendorController extends BaseController {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/{id}")
	public @ResponseBody List<Vendor> show(@PathVariable Long id) {
		return getReturnArray(this.vendorRepository.findOne(id));
	}

    @GetMapping("/List")
	public @ResponseBody Iterable<Vendor> index() {
    	return vendorRepository.findAll();
    }
    
//    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @PostMapping("/Add") 
    public @ResponseBody Vendor create(@RequestBody Vendor vendor) {
        vendorRepository.save(vendor);
        System.out.println("Vendor saved:  "+vendor);
        return vendor;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	Vendor vendor = this.vendorRepository.findOne(id);
        if(vendor != null) {
        	this.vendorRepository.delete(vendor);
        }
    }
    
}