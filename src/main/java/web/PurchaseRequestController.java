package web;

import org.springframework.web.bind.annotation.RestController;

import domain.purchaserequest.PurchaseRequest;
import domain.purchaserequest.PurchaseRequestRepository;
import domain.vendor.Vendor;

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
@RequestMapping("/PurchaseRequests")
@EntityScan("domain")
@EnableJpaRepositories("domain")
public class PurchaseRequestController extends BaseController {
	
	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;
	
	@GetMapping("/{id}")
	public @ResponseBody List<PurchaseRequest> show(@PathVariable Long id) {
		return getReturnArray(this.purchaseRequestRepository.findOne(id));
	}

    @GetMapping("/List")
	public @ResponseBody Iterable<PurchaseRequest> List() {
    	return purchaseRequestRepository.findAll();
    }
    
    @PostMapping("/Add") 
    public @ResponseBody PurchaseRequest create(@RequestBody PurchaseRequest purchaseRequest) {
        purchaseRequestRepository.save(purchaseRequest);
        System.out.println("Vendor saved:  "+purchaseRequest);
        return purchaseRequest;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	PurchaseRequest purchaserequest = this.purchaseRequestRepository.findOne(id);
        if(purchaserequest != null) {
        	this.purchaseRequestRepository.delete(purchaserequest);
        }
    }

}