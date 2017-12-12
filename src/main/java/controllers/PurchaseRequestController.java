package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.PurchaseRequest;
import repositories.PurchaseRequestRepository;

@RestController
@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class PurchaseRequestController {
	
	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;
	
	@GetMapping(value = "/PurchaseRequests/{id}")
	public @ResponseBody PurchaseRequest getPurchaseRequestById(@PathVariable Integer id) {
		return this.purchaseRequestRepository.findOne(id);
	}

    @GetMapping("/PurchaseRequests/All")
	public @ResponseBody Iterable<PurchaseRequest> getAllPurchaseRequests() {
    	return purchaseRequestRepository.findAll();
    }

}