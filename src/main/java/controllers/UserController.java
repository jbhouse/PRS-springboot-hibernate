package controllers;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.User;
import entities.Vendor;
import repositories.UserRepository;

@RestController
@RequestMapping("/Users")
//@ComponentScan(basePackages = {"repositories", "entities", "contollers"})
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class UserController {
		
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody User getUserById(@PathVariable Long id) {
		return this.userRepository.findOne(id);
	}

    @GetMapping("/All")
	public @ResponseBody Iterable<User> getAllUsers() {
    	return userRepository.findAll();
    }
    
//    @PostMapping
//    public String create() {
//        return "redirect:/users/all";
//    }
    
//    public User create() {
//    	User u = new User();
//    	u.setUserName("testuser");
//    	u.setPassword("password");
//    	u.setFirstName("test");
//    	u.setLastName("user");
//    	u.setPhone("1110009999");
//    	u.setEmail("test@user.com");
//    	u.setIsReviewer(false);
//    	u.setIsActive(true);
//    	u.setIsAdmin(false);
//    	u.setDateCreated(new Timestamp(System.currentTimeMillis()));
//    	u.setDateUpdated(new Timestamp(System.currentTimeMillis()));
//    	return u;
//    }

//    @PutMapping("{id}")
//    public User update(...) {...}

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	User user = this.userRepository.findOne(id);
        if(user != null) {
        	this.userRepository.delete(user);
        }
    }

}