package fksz.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Offer extends BaseEntity {

	@ManyToOne
	private User partner;

	@ManyToOne
	private Cut cut;

	@ManyToOne
	private Spot spot;

	private String description;

	public Offer() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
