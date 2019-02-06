package fksz.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Resource {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private ResourceType type;
	
	private int maxOnOffer;
	private String description;
	
	@OneToMany(mappedBy="resource")
	private List<ResourceToOffer> resourceToOffers;
	
	public Resource() {}
	
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
	public ResourceType getType() {
		return type;
	}
	public void setType(ResourceType type) {
		this.type = type;
	}
	public int getMaxOnOffer() {
		return maxOnOffer;
	}
	public void setMaxOnOffer(int maxOnOffer) {
		this.maxOnOffer = maxOnOffer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
