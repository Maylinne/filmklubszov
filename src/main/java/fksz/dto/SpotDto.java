package fksz.dto;

public class SpotDto {

	private int id;
	private String name;
	private int places;
	private int locationId;
	private String description;
	
	public SpotDto() {}

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

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int location) {
		this.locationId = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
