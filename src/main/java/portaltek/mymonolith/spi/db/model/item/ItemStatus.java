package portaltek.mymonolith.spi.db.model.item;

public enum ItemStatus {
	NEW("NEW", "New"),
	IN_REVIEW("IN_REVIEW", "In Review"),
	PUBLISHED("PUBLISHED", "Published")
	;
	private String code;
	private String display;

	ItemStatus(String code, String display) {
		this.code = code;
		this.display = display;
	}

	public String code() {
		return code;
	}

	public String display() {
		return display;
	}
}
