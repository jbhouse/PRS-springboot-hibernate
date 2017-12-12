package repositories;

import org.springframework.data.repository.CrudRepository;

import entities.PurchaseRequestLineItem;

public interface PurchaseRequestLineItemRepository extends CrudRepository<PurchaseRequestLineItem, Integer> {

}
