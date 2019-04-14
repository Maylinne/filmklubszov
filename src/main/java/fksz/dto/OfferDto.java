package fksz.dto;

public class OfferDto {
	
	private int id;
	private CutDto cut;
	private SpotDto spot;
	private String description;
	private UserDto partner;
	
	public OfferDto() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	public UserDto getPartner() {
		return partner;
	}

	public void setPartner(UserDto partner) {
		this.partner = partner;
	}

	public CutDto getCut() {
		return cut;
	}

	public void setCut(CutDto cut) {
		this.cut = cut;
	}

	public SpotDto getSpot() {
		return spot;
	}

	public void setSpot(SpotDto spot) {
		this.spot = spot;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
