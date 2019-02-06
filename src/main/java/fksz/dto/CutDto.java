package fksz.dto;

public class CutDto {

	private String title;
	private String hungarianTitle;
	private int year;
	private int length;
	private String imdbUrl;
	private String cut;
	private String description;
	private FilmMetaDto filmMeta;
	
	public CutDto() {}

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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
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

	public FilmMetaDto getFilmMeta() {
		return filmMeta;
	}

	public void setFilmMeta(FilmMetaDto filmMeta) {
		this.filmMeta = filmMeta;
	}
	
	
	

}
