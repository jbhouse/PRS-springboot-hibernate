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

import entities.Status;
import entities.User;
import repositories.StatusRepository;

@RestController
@RequestMapping("/Status")
//@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class StatusController {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody Status getStatusById(@PathVariable Long id) {
		return this.statusRepository.findOne(id);
	}

    @GetMapping("/All")
	public @ResponseBody Iterable<Status> getAllStatus() {
    	return statusRepository.findAll();
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	Status status = this.statusRepository.findOne(id);
        if(status != null) {
        	this.statusRepository.delete(status);
        }
    }

}