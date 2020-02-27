package fksz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.dao.ConfigurationDao;
import fksz.dto.ConfigurationDto;
import fksz.transformers.ConfigurationTransformer;

@Component
public class ConfigurationService {
	
	@Autowired ConfigurationDao dao;
	
	@Autowired ConfigurationTransformer transformer;
	
	public ConfigurationDto getByItemName (String itemName) {
		return transformer.entityToDto(dao.findByItemName(itemName));
	}

	public void save(ConfigurationDto dto) {
		dao.save(transformer.dtoToEntity(dto));
	}
}
