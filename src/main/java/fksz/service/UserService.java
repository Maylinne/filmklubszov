package fksz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fksz.dao.UserDao;
import fksz.domain.MyUserPrincipal;
import fksz.domain.User;
import fksz.dto.UserDto;
import fksz.transformers.UserTransformer;

@Component
public class UserService implements UserDetailsService{

	@Autowired
	UserDao dao;
	
	@Autowired
	UserTransformer transformer;

	public void save(UserDto dto) {
		dao.save(transformer.dtoToEntity(dto));
	}

	public void saveAll(List<UserDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}

	public void delete(UserDto dto) {
		dao.delete(transformer.dtoToEntity(dto));
	}

	public void deleteById(Integer id) {
		dao.delete(id);
	}

	public User getById(Integer id) {
		return dao.findById(id);
	}

	public List<UserDto> getAll() {
		return transformer.entiesToDtos(dao.findAll());
	}

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = dao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new MyUserPrincipal(user);
    }
    
    
    
    
    
}
