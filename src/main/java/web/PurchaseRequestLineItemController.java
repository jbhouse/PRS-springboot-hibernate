package web;

import org.springframework.web.bind.annotation.RestController;

import domain.purchaserequest.PurchaseRequestLineItem;
import domain.purchaserequest.PurchaseRequestLineItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/PurchaseRequestLineItems")
//@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("domain")
@EnableJpaRepositories("domain")
public class PurchaseRequestLineItemController {
	
	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody PurchaseRequestLineItem getPurchaseRequestLineItemById(@PathVariable Long id) {
		return this.purchaseRequestLineItemRepository.findOne(id);
	}

    @GetMapping("/List")
	public @ResponseBody Iterable<PurchaseRequestLineItem> getAllPurchaseRequestLineItems() {
    	return purchaseRequestLineItemRepository.findAll();
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	PurchaseRequestLineItem prli = this.purchaseRequestLineItemRepository.findOne(id);
        if(prli != null) {
        	this.purchaseRequestLineItemRepository.delete(prli);
        }
    }

}