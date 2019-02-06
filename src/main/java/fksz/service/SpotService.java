package fksz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.dao.SpotDao;
import fksz.domain.Spot;
import fksz.dto.SpotDto;
import fksz.transformers.SpotTransformer;

@Component
public class SpotService {
	
	@Autowired
	SpotDao dao;
	
	@Autowired
	SpotTransformer transformer;
	

	public void save(SpotDto dto) {
		dao.save(transformer.dtoToEntity(dto));
	}

	public void saveAll(List<SpotDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}

	public void delete(SpotDto dto) {
		dao.delete(transformer.dtoToEntity(dto));
	}

	public void deleteById(Integer id) {
		dao.delete(id);
	}

	public Spot getById(Integer id) {
		return dao.findById(id);
	}

	public List<SpotDto> getAll() {
		return transformer.entitiesToDtos(dao.findAll());
	}
	
	
	
}
