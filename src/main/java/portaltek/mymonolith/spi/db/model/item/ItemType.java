package portaltek.mymonolith.spi.db.model.item;

public enum ItemType {
	MC("MC", "MultiChoice"),
	MF("MF", "MathFormula")
	;
	private String code;
	private String display;



	ItemType(String code, String display) {
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
