package fksz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.dao.CutDao;
import fksz.dto.CutDto;
import fksz.models.CutModel;
import fksz.transformers.CutTransformer;

@Component
public class CutService {
	
	@Autowired
	CutDao dao;
	
	@Autowired
	CutTransformer transformer;
	
	
	public Map<Integer, String> getTheAvailableCuts() {
		Map<Integer, String> cutMap = new HashMap<>();
		List<CutModel> cutList = transformer.dtosToModels(getAll());
		
		for (CutModel cutModel : cutList) {
			cutMap.put(cutModel.getCutId(), cutModel.getHungarianTitle() + " - " + cutModel.getFilmMetaHungarianTitle());
		}
		
		return cutMap;
	}
	
	public void save(CutDto dto) {
		dao.save(transformer.dtoToEntity(dto, false));
	}
	
	public void saveAll(List<CutDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}
	
	public void delete(CutDto dto) {
		dao.delete(transformer.dtoToEntity(dto, false));
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

	public List<CutDto> getByIds(List<Integer> cutsIds) {
		// TODO Auto-generated method stub
		return null;
	}
	

	


}
