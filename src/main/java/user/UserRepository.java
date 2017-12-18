package user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserNameAndPassword(String uname, String pwd);
	
}
