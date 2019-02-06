package fksz.models;

import fksz.domain.Cut;
import fksz.domain.Spot;
import fksz.domain.User;

public class OfferModel {

	private int id;
	private User partner;
	private Cut cut;
	private Spot spot;
	private String description;
	
	public OfferModel() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getPartner() {
		return partner;
	}
	public void setPartner(User partner) {
		this.partner = partner;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Cut getCut() {
		return cut;
	}

	public void setCut(Cut cut) {
		this.cut = cut;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}


}
