package portaltek.mymonolith.spi.util.jpa;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.StringJoiner;


@Embeddable
public class Audit {

	@CreatedDate
	protected LocalDateTime createdOn;

	@LastModifiedDate
	protected LocalDateTime updatedOn;

	@CreatedBy
	@Column(length = ColumnLength.USERNAME)
	protected String createdBy;

	@LastModifiedBy
	@Column(length = ColumnLength.USERNAME)
	protected String updatedBy;

	public LocalDateTime createdOn() {
		return this.createdOn;
	}

	public Audit createdOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public LocalDateTime updatedOn() {
		return this.updatedOn;
	}

	public Audit updatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
		return this;
	}

	public String createdBy() {
		return this.createdBy;
	}

	public Audit createdBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public String updatedBy() {
		return this.updatedBy;
	}

	public Audit updatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Audit.class.getSimpleName() + "[", "]")
			.add("createdOn=" + createdOn)
			.add("updatedOn=" + updatedOn)
			.add("createdBy='" + createdBy + "'")
			.add("updatedBy='" + updatedBy + "'")
			.toString();
	}
}
