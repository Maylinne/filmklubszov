package fksz.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fksz.domain.Offer;
import fksz.dto.OfferDto;
import fksz.models.OfferModel;
import fksz.requests.OfferRequest;

@Component
public class OfferTransformer {
	
	public OfferDto entityToDto(Offer entity) {
		OfferDto dto = new OfferDto();
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setCut(entity.getCut());
		dto.setPartner(entity.getPartner());
		dto.setSpot(entity.getSpot());
		return dto;
	}
	
	public Offer dtoToEntity(OfferDto dto) {
		Offer entity = new Offer();
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setCut(dto.getCut());
		entity.setPartner(dto.getPartner());
		entity.setSpot(dto.getSpot());
		return entity;
	}
	
	public OfferModel dtoToModel(OfferDto dto) {
		OfferModel model = new OfferModel();
		model.setId(dto.getId());
		model.setDescription(dto.getDescription());
		model.setCut(dto.getCut());
		model.setPartner(dto.getPartner());
		model.setSpot(dto.getSpot());
		return model;
	}
	
	public OfferDto requestToDto(OfferRequest request) {
		OfferDto dto = new OfferDto();
		dto.setId(request.getId());
		dto.setDescription(request.getDescription());
		dto.setCut(request.getCut());
		dto.setPartner(request.getPartner());
		dto.setSpot(request.getSpot());
		return dto;
	}
	
	public List<Offer> dtosToEntities(List<OfferDto> dtos) {
		List<Offer> entities = new ArrayList<>();
		for (OfferDto dto : dtos) {
			entities.add(dtoToEntity(dto));
		}
		return entities;
	} 
	
	public List<OfferDto> entitiesToDtos(Iterable<Offer> entities) {
		List<OfferDto> dtos = new ArrayList<>();
		for (Offer entity : entities) {
			dtos.add(entityToDto(entity));
		}
		return dtos;
	}

	public List<OfferModel> dtosToModels(List<OfferDto> dtos) {
		List<OfferModel> models = new ArrayList<>();
		for (OfferDto dto : dtos) {
			models.add(dtoToModel(dto));
		}
		return models;
	}

	public List<OfferDto> requestsToDtos(List<OfferRequest> requests) {
		List<OfferDto> dtos = new ArrayList<>();
		for (OfferRequest request : requests) {
			dtos.add(requestToDto(request));
		}
		return dtos;
	}

}
