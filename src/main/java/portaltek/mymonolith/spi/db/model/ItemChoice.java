package portaltek.mymonolith.spi.db.model;


import portaltek.mymonolith.spi.util.jpa.EntityWithUUID;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.StringJoiner;


@Entity
public class ItemChoice extends EntityWithUUID {

	@ManyToOne
	@JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "FK_ITEM_CHOICE__ITEM"))
	Item item;
	Boolean isCorrect;
	String body;
	String rationale;

	public Item item() {
		return this.item;
	}

	public ItemChoice item(Item item) {
		this.item = item;
		return this;
	}

	public Boolean isCorrect() {
		return this.isCorrect;
	}

	public ItemChoice isCorrect(Boolean correct) {
		isCorrect = correct;
		return this;
	}

	public String body() {
		return this.body;
	}

	public ItemChoice body(String body) {
		this.body = body;
		return this;
	}

	public String rationale() {
		return this.rationale;
	}

	public ItemChoice rationale(String rationale) {
		this.rationale = rationale;
		return this;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ItemChoice.class.getSimpleName() + "[", "]")
			.add("id='" + id + "'")
			.toString();
	}
}
