package repositories;

import org.springframework.data.repository.CrudRepository;

import entities.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {

}
