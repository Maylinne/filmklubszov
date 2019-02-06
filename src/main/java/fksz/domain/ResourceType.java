package fksz.domain;

public enum ResourceType {
	
	LICENSE ("License"), 
	SERVICE ("Service");
	
	private String type;
	
	ResourceType(String type) {
		this.type = type;
	}
	
	public String type() {
		return type;
	}

}
