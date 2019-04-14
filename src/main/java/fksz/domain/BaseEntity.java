package fksz.domain;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue
	protected int id;


	private LocalDateTime creationTime;
	private int createdById;
	private LocalDateTime lastModifiedTime;
	private int lastModifiedId;

	
	public BaseEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	
	public int getCreatedById() {
		return createdById;
	}
	
	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}
	
	public LocalDateTime getLastModifiedTime() {
		return lastModifiedTime;
	}
	
	public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	
	public int getLastModifiedId() {
		return lastModifiedId;
	}
	
	public void setLastModifiedId(int lastModifiedId) {
		this.lastModifiedId = lastModifiedId;
	}
	
	

}
