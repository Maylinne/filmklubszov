package fksz.models;

public class CutModel {
	
	private int cutId;
	private String title;
	private String hungarianTitle;
	private String year;
	private String length;
	private String imdbUrl;
	private String cut;
	private String description;
	private int filmMetaId;
	private String filmMetaTitle;
	private String filmMetaHungarianTitle;
	
	public CutModel() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHungarianTitle() {
		if(hungarianTitle == null || hungarianTitle.equals("")) {
			return title;
		} else {
			return hungarianTitle;
		}
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

	public int getFilmMetaId() {
		return filmMetaId;
	}

	public void setFilmMetaId(int filmMetaId) {
		this.filmMetaId = filmMetaId;
	}

	public String getFilmMetaTitle() {
		return filmMetaTitle;
	}

	public void setFilmMetaTitle(String filmMetaTitle) {
		this.filmMetaTitle = filmMetaTitle;
	}

	public String getFilmMetaHungarianTitle() {
		if(filmMetaHungarianTitle == null || filmMetaHungarianTitle.equals("")) {
			return filmMetaTitle;
		} else {
			return filmMetaHungarianTitle;
		}
		
	}

	public void setFilmMetaHungarianTitle(String filmMetaHungarianTitle) {
		this.filmMetaHungarianTitle = filmMetaHungarianTitle;
	}

	public int getCutId() {
		return cutId;
	}

	public void setCutId(int cutId) {
		this.cutId = cutId;
	}
	
	

}
