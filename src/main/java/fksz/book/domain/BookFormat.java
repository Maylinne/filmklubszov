package fksz.book.domain;

public enum BookFormat {
	ELECTRONIC("Electronic"), HARD_COVER("Hard cover"), SOFT_COVER("Soft cover");

	private String displayName;

	private BookFormat(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static BookFormat getByName(String name) {
		BookFormat result = null;
		for (BookFormat format : BookFormat.values()) {
			if (format.name().equals(name)) {
				result = format;
				break;
			}
		}
		return result;
	}
}
