package fksz.models;

import java.util.HashMap;
import java.util.Map;

public class OfferModel {

	private int id;
	private UserModel partner;
	private CutModel cut;
	private SpotModel spot;
	private String description;
	private Map<Integer, String> availableCuts = new HashMap<Integer, String>();
	private Map<Integer, String> availableSpots = new HashMap<Integer, String>();
	private Map<Integer, String> availableUsers = new HashMap<Integer, String>();
	
	public OfferModel() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public UserModel getPartner() {
		return partner;
	}

	public void setPartner(UserModel partner) {
		this.partner = partner;
	}

	public CutModel getCut() {
		return cut;
	}

	public void setCut(CutModel cut) {
		this.cut = cut;
	}

	public SpotModel getSpot() {
		return spot;
	}

	public void setSpot(SpotModel spot) {
		this.spot = spot;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Map<Integer, String> getAvailableCuts() {
		return availableCuts;
	}

	public void setAvailableCuts(Map<Integer, String> availableCuts) {
		this.availableCuts = availableCuts;
	}

	public Map<Integer, String> getAvailableUsers() {
		return availableUsers;
	}

	public void setAvailableUsers(Map<Integer, String> availableUsers) {
		this.availableUsers = availableUsers;
	}

	public Map<Integer, String> getAvailableSpots() {
		return availableSpots;
	}

	public void setAvailableSpots(Map<Integer, String> availableSpots) {
		this.availableSpots = availableSpots;
	}




}
