package portaltek.mymonolith.spi.util.jpa;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static java.util.Objects.isNull;

@MappedSuperclass
public abstract class EntityWithUUID {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "id", length = ColumnLength.UUID, unique = true, nullable = false)
	protected String id;

	@Transient
	private boolean persisted;

	public String id() {
		return id;
	}

	public EntityWithUUID id(String id) {
		this.id = id;
		return this;
	}

	public boolean isNew() {
		return isNull(id);
	}

	@PostPersist
	@PostLoad
	private void initPersisted() {
		persisted = true;
	}

	public boolean persisted() {
		return this.persisted;
	}
}
