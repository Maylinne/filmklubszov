package fksz.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.domain.Location;
import fksz.dto.LocationDto;
import fksz.models.LocationModel;
import fksz.requests.LocationRequest;

@Component
public class LocationTransformer {
	
	@Autowired
	SpotTransformer spotTransformer;
	
	public LocationDto entityToDto(Location entity) {
		LocationDto dto = new LocationDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCity(entity.getCity());
		dto.setAddress(entity.getAddress());
		dto.setDescription(entity.getDescription());
		dto.setSpots(spotTransformer.entitiesToDtos(entity.getSpots()));
		return dto;
	}
	
	public Location dtoToEntity(LocationDto dto) {
		Location entity = new Location();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCity(dto.getCity());
		entity.setAddress(dto.getAddress());
		entity.setDescription(dto.getDescription());
		return entity;
	}
	
	public LocationModel dtoToModel(LocationDto dto) {
		LocationModel model = new LocationModel();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setCity(dto.getCity());
		model.setAddress(dto.getAddress());
		model.setDescription(dto.getDescription());
		model.setSpots(spotTransformer.dtosToModels(dto.getSpots()));
		return model;
	}
	
	public LocationDto requestToDto(LocationRequest request) {
		LocationDto dto = new LocationDto();
		dto.setId(request.getId());
		dto.setName(request.getName());
		dto.setCity(request.getCity());
		dto.setAddress(request.getAddress());
		dto.setDescription(request.getDescription());
		return dto;
	}
	

	public List<LocationDto> entitiesToDtos(Iterable<Location> entities) {
		List<LocationDto> dtos = new ArrayList<>();
		for (Location entity : entities) {
			dtos.add(entityToDto(entity));
		}
		return dtos;
	}
	
	public List<Location> dtosToEntities(List<LocationDto> dtos) {
		List<Location> entities = new ArrayList<>();
		for (LocationDto dto : dtos) {
			entities.add(dtoToEntity(dto));
		}
		return entities;
	}

	public List<LocationModel> dtosToModels(List<LocationDto> dtos) {
		List<LocationModel> models = new ArrayList<>();
		for (LocationDto dto : dtos) {
			models.add(dtoToModel(dto));
		}
		return models;
	}

}
