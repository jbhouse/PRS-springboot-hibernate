package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.PurchaseRequestLineItem;
import repositories.PurchaseRequestLineItemRepository;

@RestController
@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class PurchaseRequestLineItemController {
	
	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(value = "/PurchaseRequestLineItems/{id}")
	public @ResponseBody PurchaseRequestLineItem getPurchaseRequestLineItemById(@PathVariable Integer id) {
		return this.purchaseRequestLineItemRepository.findOne(id);
	}

    @GetMapping("/PurchaseRequestLineItems/All")
	public @ResponseBody Iterable<PurchaseRequestLineItem> getAllPurchaseRequestLineItems() {
    	return purchaseRequestLineItemRepository.findAll();
    }

}