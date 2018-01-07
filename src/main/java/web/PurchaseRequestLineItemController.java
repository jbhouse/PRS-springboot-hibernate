package web;

import org.springframework.web.bind.annotation.RestController;

import domain.purchaserequest.PurchaseRequestLineItem;
import domain.purchaserequest.PurchaseRequestLineItemRepository;

import java.sql.Timestamp;
import java.util.List;

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
@RequestMapping("/PurchaseRequestLineItems")
@EntityScan("domain")
@EnableJpaRepositories("domain")
public class PurchaseRequestLineItemController extends BaseController {
	
	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody List<PurchaseRequestLineItem> getPurchaseRequestLineItemById(@PathVariable Long id) {
		return getReturnArray(this.purchaseRequestLineItemRepository.findOne(id));
	}
	
    @GetMapping("/List")
	public @ResponseBody Iterable<PurchaseRequestLineItem> getAllPurchaseRequestLineItems() {
    	return purchaseRequestLineItemRepository.findAll();
    }
	
    @PostMapping("/Add") 
    public @ResponseBody PurchaseRequestLineItem create(@RequestBody PurchaseRequestLineItem purchaseRequestLineItem) {
    	purchaseRequestLineItem.setDateCreated(new Timestamp(System.currentTimeMillis()));
    	purchaseRequestLineItem.setDateUpdated(new Timestamp(System.currentTimeMillis()));
    	purchaseRequestLineItemRepository.save(purchaseRequestLineItem);
        return null;
    }
    
    @PutMapping("{id}")
    public @ResponseBody Iterable<PurchaseRequestLineItem> update(@PathVariable Long id, @RequestBody PurchaseRequestLineItem purchaseRequestLineItem) {
    	PurchaseRequestLineItem prli = this.purchaseRequestLineItemRepository.findOne(id);
    	if (prli!=null) {
    		prli.setPurchaseRequest(purchaseRequestLineItem.getPurchaseRequest());
			prli.setProduct(purchaseRequestLineItem.getProduct());
			prli.setQuantity(purchaseRequestLineItem.getQuantity());
			prli.setIsActive(purchaseRequestLineItem.getIsActive());
	    	prli.setDateUpdated(new Timestamp(System.currentTimeMillis()));
			prli.setUpdatedByUser(0);
			purchaseRequestLineItemRepository.save(prli);
    	}
    	return null;
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	PurchaseRequestLineItem prli = this.purchaseRequestLineItemRepository.findOne(id);
        if(prli != null) {
        	this.purchaseRequestLineItemRepository.delete(prli);
        }
    }

}