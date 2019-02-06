package fksz.models;

import fksz.domain.FilmMeta;

public class CutModel {
	
	private String title;
	private String hungarianTitle;
	private String year;
	private String length;
	private String imdbUrl;
	private String cut;
	private String description;
	private FilmMeta filmMeta;
	
	public CutModel() {}

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

	public String getImdbUrl() {
		return imdbUrl;
	}

	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	public String getCut() {
		return cut;
	}

	public void setCut(String cut) {
		this.cut = cut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FilmMeta getFilmMeta() {
		return filmMeta;
	}

	public void setFilmMeta(FilmMeta filmMeta) {
		this.filmMeta = filmMeta;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	

}
