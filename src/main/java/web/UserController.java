package web;

import org.springframework.web.bind.annotation.RestController;

import user.User;
import user.UserRepository;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/Users")
@EntityScan("entities")
@EnableJpaRepositories("repositories")
public class UserController extends BaseController {
		
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/Authenticate") 
	public @ResponseBody List<User> authenticate (@RequestParam String uname
			, @RequestParam String pwd) {
		User u = userRepository.findByUserNameAndPassword(uname, pwd);
		return getReturnArray(u);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody List<User> Show(@PathVariable Long id) {
		return getReturnArray(this.userRepository.findOne(id));
	}

    @GetMapping("/List")
	public @ResponseBody Iterable<User> List() {
    	return userRepository.findAll();
    }
    
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @PostMapping("/Add")
//    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public User Add (@RequestBody User user) {
    	user.setDateCreated(new Timestamp(System.currentTimeMillis()));
    	user.setDateUpdated(new Timestamp(System.currentTimeMillis()));
    	userRepository.save(user);
        System.out.println("Vendor saved:  "+user);
        return null;
    }

//    @PutMapping("{id}")
//    public User update(...) {...}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	User user = this.userRepository.findOne(id);
        if(user != null) {
        	this.userRepository.delete(user);
        }
    }

}