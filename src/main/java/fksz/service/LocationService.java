package fksz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fksz.dao.LocationDao;
import fksz.domain.Location;
import fksz.dto.LocationDto;
import fksz.transformers.LocationTransformer;

@Service
public class LocationService {

	@Autowired
	LocationDao dao;
	
	@Autowired
	LocationTransformer transformer;

	public void save(LocationDto dto) {
		dao.save(transformer.dtoToEntity(dto));
	}

	public void saveAll(List<LocationDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}

	public void delete(LocationDto dto) {
		dao.delete(transformer.dtoToEntity(dto));
	}

	public void deleteById(Integer id) {
		dao.delete(id);
	}

	public LocationDto getById(Integer id) {
		return transformer.entityToDto(dao.findById(id));
	}
	
	public Location getByIdForEntity(Integer id) {
		return dao.findById(id);
	}

	public List<LocationDto> getAll() {
		return transformer.entitiesToDtos(dao.findAll());
	}

}
