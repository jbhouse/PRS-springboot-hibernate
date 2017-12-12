package repositories;

import org.springframework.data.repository.CrudRepository;

import entities.PurchaseRequest;

public interface PurchaseRequestRepository extends CrudRepository<PurchaseRequest, Integer> {

}
