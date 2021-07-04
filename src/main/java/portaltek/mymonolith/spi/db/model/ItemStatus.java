package portaltek.mymonolith.spi.db.model;

public enum ItemStatus {
	NEW("NEW", "New"),
	IN_REVIEW("IN_REVIEW", "In Review"),
	PUBLISHED("PUBLISHED", "Published")
	;
	private String cd;
	private String display;

	ItemStatus(String cd, String display) {
		this.cd = cd;
		this.display = display;
	}

	public String cd() {
		return cd;
	}

	public String display() {
		return display;
	}
}
