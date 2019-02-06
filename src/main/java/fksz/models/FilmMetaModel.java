package fksz.models;

import java.util.ArrayList;
import java.util.List;

public class FilmMetaModel {
	
	private int id;
	private String title;
	private String hungarianTitle;
	private String director;
	private List<CutModel> cuts;
	
	public FilmMetaModel() {
		cuts = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHungarianTitle() {
		return hungarianTitle;
	}
	public void setHungarianTitle(String hungarianTitle) {
		this.hungarianTitle = hungarianTitle;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

	public List<CutModel> getCuts() {
		return cuts;
	}

	public void setCuts(List<CutModel> cuts) {
		this.cuts = cuts;
	}

	
	


}
