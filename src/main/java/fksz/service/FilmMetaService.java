package fksz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fksz.dao.FilmMetaDao;
import fksz.domain.FilmMeta;
import fksz.dto.FilmMetaDto;
import fksz.transformers.FilmMetaTransformer;

@Service
public class FilmMetaService {
	
	@Autowired
	FilmMetaDao dao;
	
	@Autowired
	FilmMetaTransformer transformer;

	public void save(FilmMetaDto dto) {
		dao.save(transformer.dtoToEntity(dto));
	}

	public void saveAll(List<FilmMetaDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}

	public void delete(FilmMetaDto dto) {
		dao.delete(transformer.dtoToEntity(dto));
	}

	public void deleteById(Integer id) {
		dao.delete(id);
	}

	public FilmMetaDto getById(Integer id) {
		return transformer.entityToDto(dao.findById(id)) ;
	}
	public FilmMeta getByIdForEntity(int id) {
		return dao.findById(id);
	}

	public List<FilmMetaDto> getAll() {
		return transformer.entitiesToDtos(dao.findAll());
	}
	
	
}
