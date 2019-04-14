package fksz.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class FilmMeta extends BaseEntity{

	private String title;
	private String hungarianTitle;
	private String director;
	
	@OneToMany(mappedBy="filmMeta", fetch = FetchType.EAGER)
	private List<Cut> cuts;

	public FilmMeta() {}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}

	public String getHungarianTitle() {
		return hungarianTitle;
	}

	public void setHungarianTitle(String hungarianTitle) {
		this.hungarianTitle = hungarianTitle;
	}

	public List<Cut> getCuts() {
		return cuts;
	}

	public void setCuts(List<Cut> cuts) {
		this.cuts = cuts;
	}

}
