package fksz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.dao.SpotDao;
import fksz.dto.SpotDto;
import fksz.models.SpotModel;
import fksz.transformers.SpotTransformer;

@Component
public class SpotService {
	
	@Autowired
	SpotDao dao;
	
	@Autowired
	SpotTransformer transformer;
	

	public Map<Integer, String> getTheAvailableSpots() {
		Map<Integer, String> spotMap = new HashMap<>();
		List<SpotModel> spotList = transformer.dtosToModels(getAll());
		
		for (SpotModel spotModel : spotList) {
			spotMap.put(spotModel.getId(), spotModel.getName() + " - " + spotModel.getLocationName());
		}
		
		return spotMap;
	}
	
	public void save(SpotDto dto) {
		dao.save(transformer.dtoToEntity(dto, false));
	}

	public void saveAll(List<SpotDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}

	public void delete(SpotDto dto) {
		dao.delete(transformer.dtoToEntity(dto, false));
	}

	public void deleteById(Integer id) {
		dao.delete(id);
	}

	public SpotDto getById(Integer id) {
		return transformer.entityToDto(dao.findById(id));
	}

	public List<SpotDto> getAll() {
		return transformer.entitiesToDtos(dao.findAll());
	}
	
	
	
}
