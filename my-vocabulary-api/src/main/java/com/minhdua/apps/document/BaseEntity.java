package com.minhdua.apps.document;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BaseEntity {
	@Id
	protected String id;
	@Default
	protected Boolean isDeleted = false;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass())
			return false;
		BaseEntity entity = (BaseEntity) o;
		return Objects.equals(id, entity.id);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}