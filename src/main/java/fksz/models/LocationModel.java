package fksz.models;

import java.util.ArrayList;
import java.util.List;

public class LocationModel {

	private int id;
	private String name;
	private String city;
	private String address;
	private String description;
	private List<SpotModel> spots = new ArrayList<>();
	
	public LocationModel() { }
	
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

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<SpotModel> getSpots() {
		return spots;
	}

	public void setSpots(List<SpotModel> spots) {
		this.spots = spots;
	}


	
	
}
