package fksz.dto;

public class ConfigurationDto {
	
	private int id;
	
	private String key;
	private String value;

	public ConfigurationDto(int id, String key, String value) {
		this.id = id;
		this.key = key;
		this.value = value;
	}
	
	public ConfigurationDto() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
