package fksz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fksz.dao.OfferDao;
import fksz.domain.Cut;
import fksz.domain.Offer;
import fksz.domain.Spot;
import fksz.dto.CutDto;
import fksz.dto.OfferDto;
import fksz.dto.SpotDto;
import fksz.dto.UserDto;
import fksz.transformers.CutTransformer;
import fksz.transformers.OfferTransformer;
import fksz.transformers.SpotTransformer;
import fksz.transformers.UserTransformer;

@Component
public class OfferService {

	@Autowired
	OfferDao dao;

	@Autowired
	UserService userService;

	@Autowired
	OfferTransformer transformer;
	
	@Autowired
	UserTransformer userTransformer;
	
	@Autowired
	CutTransformer cutTransformer;
	@Autowired
	CutService cutService;
	
	@Autowired
	SpotTransformer spotTransformer;
	@Autowired
	SpotService spotService;

	public void createOffer(UserDto partner, CutDto cut, SpotDto spot, String description) {
		if (userService.getById(partner.getId()).getRole() == "ROLE_VENDOR") {
			OfferDto offer = new OfferDto();
			offer.setPartner(partner);
			offer.setCut(cut);
			offer.setSpot(spot);
			offer.setDescription(description);
			save(offer);
		} else {
			System.out.println("You cannot create an offer, if you are not a vendor.");
		}
	}
	
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
	
	public List<OfferDto> getAllByUser(UserDto user) {
		List<Offer> entities = dao.findByPartner(userTransformer.dtoToEntity(user));
		return transformer.entitiesToDtos(entities);
	}
	
	public List<OfferDto> getAllByUserId(int userId) {
		List<OfferDto> offers = new ArrayList<>();
		UserDto user = userService.getById(userId);
		offers = getAllByUser(user);
		return offers;
	}
	
	public List<OfferDto> getAllByCutId(int cutId) {
		List<OfferDto> offers = new ArrayList<>();
		Cut cut = cutTransformer.dtoToEntity(cutService.getById(cutId), true);
		offers = transformer.entitiesToDtos(dao.findByCut(cut));
		return offers;
	}
	
	public List<OfferDto> getAllBySpotId(int spotId) {
		List<OfferDto> offers = new ArrayList<>();
		Spot spot = spotTransformer.dtoToEntity(spotService.getById(spotId), true);
		offers = transformer.entitiesToDtos(dao.findBySpot(spot));
		return offers;
	}


}
