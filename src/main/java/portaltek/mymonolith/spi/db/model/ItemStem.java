package portaltek.mymonolith.spi.db.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.StringJoiner;


@Entity
public class ItemStem {

	@Id
	@Column(name = "item_id")
	String id;

	@OneToOne
	@MapsId
	@JoinColumn(name = "item_id", foreignKey = @ForeignKey(name="FK_ITEM_STEM__ITEM"))
	Item item;

	String body = "ITEM STEM: " + LocalDateTime.now();
	String teacherInstruction;
	String rationale;


	public String id() {
		return id;
	}

	public ItemStem id(String id) {
		this.id = id;
		return this;
	}

	public Item item() {
		return item;
	}

	public ItemStem item(Item item) {
		this.item = item;
		return this;
	}

	public String body() {
		return this.body;
	}

	public ItemStem body(String body) {
		this.body = body;
		return this;
	}

	public String teacherInstruction() {
		return this.teacherInstruction;
	}

	public ItemStem teacherInstruction(String teacherInstruction) {
		this.teacherInstruction = teacherInstruction;
		return this;
	}

	public String rationale() {
		return this.rationale;
	}

	public ItemStem rationale(String rationale) {
		this.rationale = rationale;
		return this;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ItemStem.class.getSimpleName() + "[", "]")
			.add("id='" + id + "'")
			.add("item=" + item)
			.add("stem='" + body + "'")
			.toString();
	}
}
