package fksz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fksz.dao.OfferDao;
import fksz.domain.Offer;
import fksz.dto.OfferDto;
import fksz.transformers.OfferTransformer;

public class OfferService {
	
	
	@Autowired
	OfferDao dao;
	
	@Autowired
	OfferTransformer transformer;
	
	
	public void save(OfferDto dto) {
		dao.save(transformer.dtoToEntity(dto));
	}

	public void saveAll(List<OfferDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}

	public void delete(OfferDto dto) {
		dao.delete(transformer.dtoToEntity(dto));
	}

	public void deleteById(Integer id) {
		dao.delete(id);
	}

	public Offer getById(Integer id) {
		return dao.findById(id);
	}

	public List<OfferDto> getAll() {
		return transformer.entitiesToDtos(dao.findAll());
	}

}
