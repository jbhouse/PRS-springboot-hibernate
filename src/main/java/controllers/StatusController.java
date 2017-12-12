package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Status;
import repositories.StatusRepository;

@RestController
@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class StatusController {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping(value = "/Status/{id}")
	public @ResponseBody Status getStatusById(@PathVariable Integer id) {
		return this.statusRepository.findOne(id);
	}

    @GetMapping("/Status/All")
	public @ResponseBody Iterable<Status> getAllStatus() {
    	return statusRepository.findAll();
    }

}