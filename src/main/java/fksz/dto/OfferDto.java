package fksz.dto;

import fksz.domain.Cut;
import fksz.domain.Spot;
import fksz.domain.User;

public class OfferDto {
	
	private int id;
	private User partner;
	private Cut cut;
	private Spot spot;
	private String description;
	
	public OfferDto() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public User getPartner() {
		return partner;
	}

	public void setPartner(User partner) {
		this.partner = partner;
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
