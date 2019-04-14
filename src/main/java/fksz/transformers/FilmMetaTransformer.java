package fksz.transformers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.authentication.service.AuthenticationService;
import fksz.dao.FilmMetaDao;
import fksz.domain.FilmMeta;
import fksz.dto.FilmMetaDto;
import fksz.models.FilmMetaModel;
import fksz.requests.FilmMetaRequest;

@Component
public class FilmMetaTransformer {
	
	@Autowired
	CutTransformer cutTransformer;
	
	@Autowired
	FilmMetaDao dao;
	
	@Autowired
	AuthenticationService authService;
	
	public FilmMeta dtoToEntity(FilmMetaDto dto) {
		FilmMeta entity = new FilmMeta();
		
		if (dto.getId() == 0) {
			entity.setCreatedById(authService.getPrincipalId());
			entity.setCreationTime(LocalDateTime.now());
		}else {
			entity.setCreatedById(dao.findById(dto.getId()).getCreatedById());
			entity.setCreationTime(dao.findById(dto.getId()).getCreationTime());
		}
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setDirector(dto.getDirector());
		entity.setHungarianTitle(dto.getHungarianTitle());
		entity.setCuts(cutTransformer.dtosToEntities(dto.getCuts()));
		entity.setLastModifiedId(authService.getPrincipalId());
		entity.setLastModifiedTime(LocalDateTime.now());
		
		return entity;
	}
	
	public FilmMetaDto entityToDto(FilmMeta entity) {
		FilmMetaDto dto = new FilmMetaDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDirector(entity.getDirector());
		dto.setHungarianTitle(entity.getHungarianTitle());
		dto.setCuts(cutTransformer.entitiesToDtos(entity.getCuts()));
		
		return dto;
	}
	
	public FilmMetaModel dtoToModel(FilmMetaDto dto) {
		FilmMetaModel model = new FilmMetaModel();
		model.setId(dto.getId());
		model.setTitle(dto.getTitle());
		model.setHungarianTitle(dto.getHungarianTitle());
		model.setDirector(dto.getDirector());
		model.setCuts(cutTransformer.dtosToModels(dto.getCuts()));
		return model;
	}
	
	
	public FilmMetaDto requestToDto(FilmMetaRequest request) {
		FilmMetaDto dto = new FilmMetaDto();
		dto.setId(request.getId());
		dto.setTitle(request.getTitle());
		dto.setHungarianTitle(request.getHungarianTitle());
		dto.setDirector(request.getDirector());
		dto.setCuts(cutTransformer.requestsToDtos(request.getCuts()));	
		return dto;
		
	}

	public List<FilmMetaModel> dtosToModels(List<FilmMetaDto> filmMetasDtos) {
		List<FilmMetaModel> models = new ArrayList<>();
		for (FilmMetaDto filmMetaDto : filmMetasDtos) {
			models.add(dtoToModel(filmMetaDto));
		}
		return models;
	}

	public List<FilmMetaDto> entitiesToDtos(Iterable<FilmMeta> entities) {
		List<FilmMetaDto> dtos = new ArrayList<>();
		for (FilmMeta entity : entities) {
			dtos.add(entityToDto(entity));
		}
		return dtos;
	}

	public List<FilmMeta> dtosToEntities(List<FilmMetaDto> dtos) {
		List<FilmMeta> entities = new ArrayList<>();
		for (FilmMetaDto dto : dtos) {
			entities.add(dtoToEntity(dto));
		}
		return null;
	}

}
