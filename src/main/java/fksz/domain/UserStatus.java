package fksz.domain;

public enum UserStatus {
	
	PENDING("Pending"),
    ACTIVATED("Activated"),
    SUSPENDED("Suspended");
	
    private String niceString;

	UserStatus(String niceString) {
        this.niceString = niceString;
    }

    public String niceString() {
        return niceString;
    }

}
