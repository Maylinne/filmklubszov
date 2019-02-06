package fksz.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fksz.domain.FilmMeta;

@Component
public interface FilmMetaDao extends CrudRepository<FilmMeta, Integer>{
	
	List<FilmMeta> findByTitleIgnoreCaseLike(String title);

	FilmMeta findById(Integer id);
	

}
