package fksz.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fksz.domain.Location;

@Component
public interface LocationDao extends CrudRepository<Location, Integer>{

	Location findById(Integer id);


}
