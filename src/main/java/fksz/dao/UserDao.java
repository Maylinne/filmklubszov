package fksz.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fksz.domain.User;

@Component
public interface UserDao extends CrudRepository<User, Integer>{

	User findById(Integer id);
	
	User findByName(String name);
	
	User findByEmail(String email);

}
