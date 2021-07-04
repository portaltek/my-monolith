package portaltek.mymonolith.spi.db.model;

public enum ItemType {
	MC("MC", "MultiChoice"),
	MF("MF", "MathFormula")
	;
	private String cd;
	private String display;



	ItemType(String cd, String display) {
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
