package fksz.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.dao.ConfigurationDao;
import fksz.domain.ConfigItem;
import fksz.dto.ConfigurationDto;
import fksz.models.ConfigurationModel;
import fksz.requests.ConfigurationRequest;

@Component
public class ConfigurationTransformer {
	
	@Autowired ConfigurationDao dao;
	
	public ConfigurationDto entityToDto(ConfigItem entity) {
		return new ConfigurationDto(entity.getId(), entity.getItemName(), entity.getValue());
	}
	
	public ConfigItem dtoToEntity(ConfigurationDto dto) {
		ConfigItem entity = new ConfigItem();
		entity.setId(dto.getId());
		entity.setItemName(dto.getKey());
		entity.setValue(dto.getValue());
		return entity;
	} 
	
	public ConfigurationModel dtoToModel(ConfigurationDto dto) {
		return new ConfigurationModel(dto.getId(), dto.getKey(), dto.getValue());
	}
	
	public ConfigurationDto requestToDto (ConfigurationRequest request) {
		return new ConfigurationDto (request.getId(), request.getKey(), request.getValue());
	}

	public List<ConfigItem> dtosToEntities(List<ConfigurationDto> dtos) {
		List<ConfigItem> entities = new ArrayList<>();
		for (ConfigurationDto dto : dtos) {
			entities.add(dtoToEntity(dto));
		}
		return entities;
	}

	public List<ConfigurationDto> entiesToDtos(Iterable<ConfigItem> entities) {
		List<ConfigurationDto> dtos = new ArrayList<>();
		for (ConfigItem entity : entities) {
			dtos.add(entityToDto(entity));
		}
		return dtos;
	}

	public List<ConfigurationModel> dtosToModels(List<ConfigurationDto> dtos) {
		List<ConfigurationModel> models = new ArrayList<>();
		for (ConfigurationDto dto : dtos) {
			models.add(dtoToModel(dto));
		}
		return models;
	}
}
