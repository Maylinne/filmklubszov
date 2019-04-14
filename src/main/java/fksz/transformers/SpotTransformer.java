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

	public Spot dtoToEntity(SpotDto dto, boolean lazy) {
		if (dto != null) {

			Spot entity = new Spot();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setPlaces(dto.getPlaces());
			if (!lazy) {
				entity.setLocation(locationService.getByIdForEntity(dto.getLocationId()));
			}
			entity.setDescription(dto.getDescription());
			return entity;
		} else
			return null;
	}

	public SpotDto entityToDto(Spot entity) {
		if (entity == null) {
			return null;
		} else {
			SpotDto dto = new SpotDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setPlaces(entity.getPlaces());
			dto.setDescription(entity.getDescription());
			dto.setLocationId(entity.getLocation().getId());
			return dto;
		}
	}

	public SpotModel dtoToModel(SpotDto dto) {
		if (dto == null) {
			return null;
		} else {

			SpotModel model = new SpotModel();
			model.setId(dto.getId());
			model.setName(dto.getName());
			model.setPlaces(dto.getPlaces());
			model.setDescription(dto.getDescription());
			model.setLocationId(dto.getLocationId());
			model.setLocationName(
					locationService.getById(model.getLocationId()).getName());
			model.setLocationCity(
					locationService.getById(model.getLocationId()).getCity());
			model.setLocationAddress(
					locationService.getById(model.getLocationId()).getAddress());
			return model;
		}
	}

	public SpotDto requestToDto(SpotRequest request) {
		SpotDto dto = new SpotDto();
		dto.setId(request.getId());
		dto.setName(request.getName());
		dto.setPlaces(request.getPlaces());
		dto.setLocationId(request.getLocationId());
		dto.setDescription(request.getDescription());
		return dto;
	}

	public List<Spot> dtosToEntities(List<SpotDto> dtos) {
		List<Spot> entities = new ArrayList<>();
		for (SpotDto dto : dtos) {
			entities.add(dtoToEntity(dto, false));
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
