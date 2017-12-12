package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.User;
import repositories.UserRepository;

@RestController
@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/Users/{id}")
	public @ResponseBody User getUserById(@PathVariable Integer id) {
		return this.userRepository.findOne(id);
	}

    @GetMapping("/Users/All")
	public @ResponseBody Iterable<User> getAllUsers() {
    	return userRepository.findAll();
    }

}