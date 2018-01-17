package web;

import org.springframework.web.bind.annotation.RestController;

import domain.user.User;
import domain.vendor.Vendor;
import domain.vendor.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@RestController
@RequestMapping("/Vendors")
@EntityScan("domain")
@EnableJpaRepositories("domain")
public class VendorController extends BaseController {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/{id}")
	public @ResponseBody Iterable<Vendor> show(@PathVariable Long id) {
		return getReturnArray(this.vendorRepository.findOne(id));
	}

    @GetMapping("/List")
	public @ResponseBody Iterable<Vendor> index() {
    	return vendorRepository.findAll();
    }
    
    @PostMapping("/Add") 
    public Vendor Add (@RequestBody Vendor vendor) {
    	System.out.println("----------------------------------------");
    	System.out.println(vendor);
    	System.out.println("----------------------------------------");
        vendorRepository.save(vendor);
        System.out.println("Vendor saved:  "+vendor);
        return null;
    }
    
    @PutMapping("{id}")
    public @ResponseBody Iterable<User> update(@PathVariable Long id, @RequestBody Vendor vendor) {
    	Vendor v = this.vendorRepository.findOne(id);
    	if (v!=null) {
			v.setCode(vendor.getCode());
			v.setName(vendor.getName());
			v.setAddress(vendor.getAddress());
			v.setCity(vendor.getCity());
			v.setZip(vendor.getZip());
			v.setPhone(vendor.getPhone());
			v.setPhone(vendor.getPhone());
			v.setEmail(vendor.getEmail());
			v.setIsActive(vendor.getIsActive());
			v.setUpDatedByUser(0);
			vendorRepository.save(v);
    	}
    	return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	Vendor vendor = this.vendorRepository.findOne(id);
        if(vendor != null) {
        	this.vendorRepository.delete(vendor);
        }
    }
    
}