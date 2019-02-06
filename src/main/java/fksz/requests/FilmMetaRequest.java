package fksz.requests;

import java.util.ArrayList;
import java.util.List;

public class FilmMetaRequest {

	private int id;
	private String title;
	private String hungarianTitle;
	private String director;
	private List<CutRequest> cuts = new ArrayList<>();
	
	
	public FilmMetaRequest() {
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

	public List<CutRequest> getCuts() {
		return cuts;
	}

	public void setCuts(List<CutRequest> cuts) {
		this.cuts = cuts;
	}




}
