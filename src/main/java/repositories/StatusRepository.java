package repositories;

import org.springframework.data.repository.CrudRepository;

import entities.Status;

public interface StatusRepository extends CrudRepository<Status, Long> {

}