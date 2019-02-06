package fksz.requests;

import java.util.ArrayList;
import java.util.List;

public class PartnerRequest {

	private int id;
	private String name;
	private String description;
	private List<OfferRequest> offers = new ArrayList<>();

	PartnerRequest() {
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

	public List<OfferRequest> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferRequest> offers) {
		this.offers = offers;
	}

}
