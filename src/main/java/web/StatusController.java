package web;

import org.springframework.web.bind.annotation.RestController;

import status.Status;
import status.StatusRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/Status")
//@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class StatusController extends BaseController {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody List<Status> getStatusById(@PathVariable Long id) {
		return getReturnArray(this.statusRepository.findOne(id));
	}

    @GetMapping("/List")
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