package fksz.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fksz.domain.Spot;

@Component
public interface SpotDao extends CrudRepository<Spot, Integer> {

	Spot findById(Integer id);
	

}
