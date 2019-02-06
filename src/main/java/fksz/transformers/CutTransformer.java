package fksz.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.domain.Cut;
import fksz.dto.CutDto;
import fksz.models.CutModel;
import fksz.requests.CutRequest;
import fksz.service.FilmMetaService;

@Component
public class CutTransformer {
	
	@Autowired
	FilmMetaService filmMetaService;
	
	@Autowired
	FilmMetaTransformer filmMetaTransformer;
	
	public Cut dtoToEntity (CutDto dto) {
		Cut entity = new Cut();
		
		entity.setTitle(dto.getTitle());
		entity.setHungarianTitle(dto.getHungarianTitle());
		entity.setYear(dto.getYear());
		entity.setLength(dto.getLength());
		entity.setImdbUrl(dto.getImdbUrl());
		entity.setCut(dto.getCut());
		entity.setDescription(dto.getDescription());
		entity.setFilmMeta(filmMetaTransformer.dtoToEntity(dto.getFilmMeta()));
		
		return entity;
	}
	
	public CutDto entityToDto (Cut entity) {
		CutDto dto = new CutDto();
		
		dto.setTitle(entity.getTitle());
		dto.setHungarianTitle(entity.getHungarianTitle());
		dto.setYear(entity.getYear());
		dto.setLength(entity.getLength());
		dto.setImdbUrl(entity.getImdbUrl());
		dto.setCut(entity.getCut());
		dto.setDescription(entity.getDescription());
		
		return dto;
		
	}
	
	public CutModel dtoToModel(CutDto dto) {
		CutModel model = new CutModel();
		model.setTitle(dto.getTitle());
		model.setHungarianTitle(dto.getHungarianTitle());
		model.setYear(Integer.toString(dto.getYear()));
		model.setLength(Integer.toString(dto.getLength()));
		model.setImdbUrl(dto.getImdbUrl());
		model.setCut(dto.getCut());
		model.setDescription(dto.getDescription());
		return model;
	}
	
	public CutDto requestToDto(CutRequest request) {
		CutDto dto = new CutDto();
		
		dto.setTitle(request.getTitle());
		dto.setHungarianTitle(request.getHungarianTitle());
		dto.setYear(Integer.parseInt(request.getYear()));
		dto.setLength(Integer.parseInt(request.getLength()));
		dto.setImdbUrl(request.getImdbUrl());
		dto.setCut(request.getCut());
		dto.setDescription(request.getDescription());
		dto.setFilmMeta(filmMetaService.getById(request.getFilmMetaId()));

		return dto;
	}

	public List<Cut> dtosToEntities(List<CutDto> dtos) {
		List<Cut> entities = new ArrayList<>();
		for (CutDto dto : dtos) {
			entities.add(dtoToEntity(dto));
		}
		return entities;
	}

	public List<CutDto> entitiesToDtos(Iterable<Cut> entities) {
		List<CutDto> dtos = new ArrayList<>();
		for (Cut entity : entities) {
			dtos.add(entityToDto(entity));
		}
		return dtos;
	}

	public List<CutModel> dtosToModels(List<CutDto> dtos) {
		List<CutModel> models = new ArrayList<>();
		for (CutDto dto : dtos) {
			models.add(dtoToModel(dto));
		}
		return models;
	}

	public List<CutDto> requestsToDtos(List<CutRequest> requests) {
		List<CutDto> dtos = new ArrayList<>();
		for (CutRequest request : requests) {
			dtos.add(requestToDto(request));
		}
		return dtos;
	}

}
