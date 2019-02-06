package fksz.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fksz.domain.Cut;

@Component
public interface CutDao extends CrudRepository<Cut, Integer>{

	Cut findById(Integer id);
	
}
