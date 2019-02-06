package fksz.dto;

import java.util.ArrayList;
import java.util.List;

public class FilmMetaDto {

	private int id;
	private String title;
	private String hungarianTitle;
	private String director;
	private List<CutDto> cuts;
	
	public FilmMetaDto() {
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

	public List<CutDto> getCuts() {
		return cuts;
	}

	public void setCuts(List<CutDto> cuts) {
		this.cuts = cuts;
	}


	
	
}