package web;

import org.springframework.web.bind.annotation.RestController;

import domain.purchaserequest.PurchaseRequest;
import domain.purchaserequest.PurchaseRequestLineItem;
import domain.purchaserequest.PurchaseRequestRepository;

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
    
    @GetMapping("/LineItems/{id}")
	public @ResponseBody Iterable<PurchaseRequestLineItem> ListLineItems(@PathVariable Long id) {
    	return purchaseRequestRepository.findOne(id).getlineItems();
    }
    
    @PostMapping("/Add") 
    public @ResponseBody PurchaseRequest create(@RequestBody PurchaseRequest purchaseRequest) {
    	purchaseRequest.setDateCreated(new Timestamp(System.currentTimeMillis()));
    	purchaseRequest.setDateUpdated(new Timestamp(System.currentTimeMillis()));
    	purchaseRequest.setSubmittedDate();
        purchaseRequestRepository.save(purchaseRequest);
        System.out.println("Vendor saved:  "+purchaseRequest);
        return purchaseRequest;
    }
    
    @PutMapping("{id}")
    public @ResponseBody Iterable<PurchaseRequest> update(@PathVariable Long id, @RequestBody PurchaseRequest purchaserequest) {
    	PurchaseRequest pr = this.purchaseRequestRepository.findOne(id);
    	if (pr!=null) {
    		pr.setStatus(purchaserequest.getStatus());
			pr.setlineItems(purchaserequest.getlineItems());
			pr.setDescription(purchaserequest.getDescription());
			pr.setJustification(purchaserequest.getJustification());
			pr.setDateNeeded(purchaserequest.getDateNeeded());
			pr.setDeliveryMode(purchaserequest.getDeliveryMode());
			pr.setSubmittedDate(purchaserequest.getSubmittedDate());
			pr.setIsActive(purchaserequest.getIsActive());
			pr.setReasonForRejection(purchaserequest.getReasonForRejection());
	    	pr.setDateUpdated(new Timestamp(System.currentTimeMillis()));
			pr.setUpdatedByUser(0);
			purchaseRequestRepository.save(pr);
    	}
    	return null;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	PurchaseRequest purchaserequest = this.purchaseRequestRepository.findOne(id);
        if(purchaserequest != null) {
        	this.purchaseRequestRepository.delete(purchaserequest);
        }
    }

}