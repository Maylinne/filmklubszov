package fksz.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fksz.domain.Cut;
import fksz.domain.Offer;
import fksz.domain.Spot;
import fksz.domain.User;

public interface OfferDao extends CrudRepository<Offer, Integer>{

	Offer findById(Integer id);
	List<Offer> findByPartner(User partner);
	List<Offer> findByCut(Cut cut);
	List<Offer> findBySpot(Spot spot);
	

}
