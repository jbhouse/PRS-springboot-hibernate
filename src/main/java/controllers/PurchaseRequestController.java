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

import entities.PurchaseRequest;
import entities.PurchaseRequestLineItem;
import repositories.PurchaseRequestRepository;

@RestController
@RequestMapping("/PurchaseRequests")
//@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class PurchaseRequestController {
	
	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody PurchaseRequest getPurchaseRequestById(@PathVariable Long id) {
		return this.purchaseRequestRepository.findOne(id);
	}

    @GetMapping("/All")
	public @ResponseBody Iterable<PurchaseRequest> getAllPurchaseRequests() {
    	return purchaseRequestRepository.findAll();
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	PurchaseRequest purchaserequest = this.purchaseRequestRepository.findOne(id);
        if(purchaserequest != null) {
        	this.purchaseRequestRepository.delete(purchaserequest);
        }
    }

}