package portaltek.mymonolith.spi.db.model.item;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import portaltek.mymonolith.spi.util.jpa.Audit;
import portaltek.mymonolith.spi.util.jpa.ColumnLength;
import portaltek.mymonolith.spi.util.jpa.EntityWithUUID;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static java.util.Objects.isNull;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Item extends EntityWithUUID {

	@Embedded
	Audit audit = new Audit();
	@Column(length = ColumnLength.CODE)
	String code = "ITEM_CODE: " + LocalDateTime.now();

	@OneToOne(cascade = ALL, fetch = EAGER, mappedBy = "item")
	@PrimaryKeyJoinColumn
	ItemStem stem;

	@OneToMany(cascade = ALL, fetch = LAZY)
	@JoinColumn(name = "item_id")
	List<ItemChoice> choices = new ArrayList<>();

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	ItemType type;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	ItemStatus status = ItemStatus.NEW;


	public Item stem(ItemStem stem) {
		this.stem = stem;
		stem.item(this);
		return this;
	}

	public Item choices(List<ItemChoice> choices) {
		this.choices = choices;
		if (isNull(choices)) return this;
		this.choices.forEach(this::addItemChoice);
		return this;
	}

	public Item addItemChoice(ItemChoice itemChoice) {
		itemChoice.item(this);
		choices.add(itemChoice);
		return this;
	}






	public Audit audit() {
		return this.audit;
	}

	public Item audit(Audit audit) {
		this.audit = audit;
		return this;
	}

	public String code() {
		return this.code;
	}

	public Item code(String code) {
		this.code = code;
		return this;
	}

	public ItemStem stem() {
		return this.stem;
	}

	public List<ItemChoice> choices() {
		return this.choices;
	}

	public ItemType type() {
		return this.type;
	}

	public Item type(ItemType type) {
		this.type = type;
		return this;
	}

	public ItemStatus status() {
		return this.status;
	}

	public Item status(ItemStatus status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
			.add("id='" + id + "'")
			.add("audit=" + audit)
			.add("code='" + code + "'")
			.toString();
	}
}
