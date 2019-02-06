package fksz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.dao.CutDao;
import fksz.dto.CutDto;
import fksz.transformers.CutTransformer;

@Component
public class CutService {
	
	@Autowired
	CutDao dao;
	
	@Autowired
	CutTransformer transformer;
	
	public void save(CutDto dto) {
		dao.save(transformer.dtoToEntity(dto));
	}
	
	public void saveAll(List<CutDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}
	
	public void delete(CutDto dto) {
		dao.delete(transformer.dtoToEntity(dto));
	}
	
	public void deleteById (Integer id) {
		dao.delete(id);
	}
	
	public CutDto getById(Integer id) {
		return transformer.entityToDto(dao.findById(id));
	}
	
	
	public List<CutDto> getAll() {
		return transformer.entitiesToDtos(dao.findAll());
	}
	

	


}
