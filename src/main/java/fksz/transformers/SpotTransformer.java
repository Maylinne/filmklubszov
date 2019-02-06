package fksz.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.domain.Spot;
import fksz.dto.SpotDto;
import fksz.models.SpotModel;
import fksz.requests.SpotRequest;
import fksz.service.LocationService;

@Component
public class SpotTransformer {
	
	@Autowired
	LocationTransformer locationTransformer;
	
	@Autowired
	LocationService locationService;
	
	public SpotDto entityToDto(Spot entity) {
		SpotDto dto = new SpotDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPlaces(entity.getPlaces());
		dto.setDescription(entity.getDescription());
		return dto;
	}
	
	public Spot dtoToEntity(SpotDto dto) {
		Spot entity = new Spot();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPlaces(dto.getPlaces());
		entity.setLocation(locationService.getLocById(dto.getLocation()));
		entity.setDescription(dto.getDescription());
		return entity;
	}
	
	public SpotModel dtoToModel(SpotDto dto) {
		SpotModel model = new SpotModel();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setPlaces(dto.getPlaces());
		model.setDescription(dto.getDescription());
		return model;
	}
	
	public SpotDto requestToDto(SpotRequest request) {
		SpotDto dto = new SpotDto();
		dto.setId(request.getId());
		dto.setName(request.getName());
		dto.setPlaces(request.getPlaces());
		dto.setLocation(request.getLocationId());
		dto.setDescription(request.getDescription());
		return dto;
	}
	
	public List<Spot> dtosToEntities(List<SpotDto> dtos) {
		List<Spot> entities = new ArrayList<>();
		for (SpotDto dto : dtos) {
			entities.add(dtoToEntity(dto));
		}
		return entities;
	} 
	
	public List<SpotDto> entitiesToDtos(Iterable<Spot> entities) {
		List<SpotDto> dtos = new ArrayList<>();
		for (Spot entity : entities) {
			dtos.add(entityToDto(entity));
		}
		return dtos;
	}

	public List<SpotModel> dtosToModels(List<SpotDto> dtos) {
		List<SpotModel> models = new ArrayList<>();
		for (SpotDto dto : dtos) {
			models.add(dtoToModel(dto));
		}
		return models;
	}

	public List<SpotDto> requestsToDtos(List<SpotRequest> requests) {
		List<SpotDto> dtos = new ArrayList<>();
		for (SpotRequest request : requests) {
			dtos.add(requestToDto(request));
		}
		return dtos;
	}

}
