package fksz.dao;

import org.springframework.data.repository.CrudRepository;

import fksz.domain.Offer;

public interface OfferDao extends CrudRepository<Offer, Integer>{

	Offer findById(Integer id);

}
