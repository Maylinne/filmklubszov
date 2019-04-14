package fksz.transformers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.authentication.service.AuthenticationService;
import fksz.dao.OfferDao;
import fksz.domain.Offer;
import fksz.dto.OfferDto;
import fksz.models.OfferModel;
import fksz.requests.OfferRequest;
import fksz.service.CutService;
import fksz.service.SpotService;
import fksz.service.UserService;

@Component
public class OfferTransformer {

	@Autowired CutTransformer cutTransformer;
	@Autowired CutService cutService;
	@Autowired UserTransformer userTransformer;
	@Autowired UserService userService;
	@Autowired SpotTransformer spotTransformer;
	@Autowired SpotService spotService;	
	@Autowired AuthenticationService authService;
	@Autowired OfferDao dao;
	

	public OfferDto entityToDto(Offer entity) {
		OfferDto dto = new OfferDto();
		
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setCut(cutTransformer.entityToDto(entity.getCut()));
		dto.setPartner(userTransformer.entitytoDto(entity.getPartner()));
		dto.setSpot(spotTransformer.entityToDto(entity.getSpot()));
		return dto;
	}

	public Offer dtoToEntity(OfferDto dto) {
		Offer entity = new Offer();
		if (dto.getId() == 0) {
			entity.setCreatedById(authService.getPrincipalId());
			entity.setCreationTime(LocalDateTime.now());
		} else {
			entity.setCreatedById(dao.findById(dto.getId()).getCreatedById());
			entity.setCreationTime(dao.findById(dto.getId()).getCreationTime());
		}
		
		entity.setLastModifiedId(authService.getPrincipalId());
		entity.setLastModifiedTime(LocalDateTime.now());
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setCut(cutTransformer.dtoToEntity(dto.getCut(), true));
		entity.setPartner(userTransformer.dtoToEntity(dto.getPartner()));
		entity.setSpot(spotTransformer.dtoToEntity(dto.getSpot(), true));
		return entity;
	}

	public OfferModel dtoToModel(OfferDto dto) {
		OfferModel model = new OfferModel();
		model.setId(dto.getId());
		model.setDescription(dto.getDescription());
		model.setCut(cutTransformer.dtoToModel(dto.getCut()));
		model.setAvailableCuts(cutService.getTheAvailableCuts());
		model.setPartner(userTransformer.dtoToModel(dto.getPartner()));
		model.setSpot(spotTransformer.dtoToModel(dto.getSpot()));
		return model;
	}

	public OfferDto requestToDto(OfferRequest request) {
		OfferDto dto = new OfferDto();
		dto.setId(request.getId());
		dto.setDescription(request.getDescription());
		dto.setCut(cutService.getById(request.getCutId()));
		dto.setPartner(userService.getById(request.getPartnerId()));
		dto.setSpot(spotService.getById(request.getSpotId()));
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
