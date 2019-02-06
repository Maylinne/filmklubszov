package fksz.models;

import java.util.ArrayList;
import java.util.List;

public class PartnerModel {

	private int id;
	private String name;
	private String description;
	private List<OfferModel> offers = new ArrayList<>();

	public PartnerModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<OfferModel> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferModel> offers) {
		this.offers = offers;
	}

}
