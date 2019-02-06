package fksz.dto;

import java.util.ArrayList;
import java.util.List;

public class LocationDto {
	
	private int id;
	private String name;
	private String city;
	private String address;
	private String description;
	private List<SpotDto> spots;
	
	public LocationDto() { 
		spots = new ArrayList<>();
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

	public List<SpotDto> getSpots() {
		return spots;
	}

	public void setSpots(List<SpotDto> spots) {
		this.spots = spots;
	}



	

}
